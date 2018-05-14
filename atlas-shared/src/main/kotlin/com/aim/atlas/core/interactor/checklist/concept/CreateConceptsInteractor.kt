package com.aim.atlas.core.interactor.checklist.concept

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.checklist.ConceptRequestMapper
import com.aim.atlas.core.mapper.checklist.ConceptResponseMapper
import com.aim.atlas.core.repository.checklist.ConceptRepository
import com.aim.atlas.core.repository.checklist.LabelRepository
import com.aim.atlas.core.specification.checklist.ConceptSpecification
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith
import javax.inject.Named

@TestOpen
@Named("create_concepts_interactor")
class CreateConceptsInteractor(
        private val conceptRepository: ConceptRepository,
        private val labelRepository: LabelRepository,
        private val specification: ConceptSpecification,
        private val mapper: ConceptRequestMapper,
        private val responseMapper: ConceptResponseMapper
):
        MaybeInteractor<List<ConceptResponse>>(),
        InputBoundary<CreateConceptsRequest, CreateConceptsInteractor> {

    lateinit var request: CreateConceptsRequest

    override fun input(input: CreateConceptsRequest): CreateConceptsInteractor {
        request = input
        return this
    }

    override fun execute(): Maybe<List<ConceptResponse>> {
        return Observable.just(request)
                .filter { it.concepts.distinctBy { it.name }.size == it.concepts.size }
                .filter { it.concepts.distinctBy { it.color }.size == it.concepts.size }
                .concatMapIterable { it.concepts }
                .map { mapper.transform(it) }
                .filter { specification.isSatisfiedBy(it) }
                .concatMap {
                    Observable.just(it).zipWith(
                            Observable.fromIterable(it.labels)
                                    .flatMapMaybe { labelRepository.create(it) }
                                    .toList()
                                    .toObservable()
                    ).flatMapMaybe { (concept, labels) ->
                        concept.labels = labels
                        conceptRepository.create(concept)
                    }
                }
                .map { responseMapper.transform(it) }
                .toList()
                .toMaybe()
    }
}