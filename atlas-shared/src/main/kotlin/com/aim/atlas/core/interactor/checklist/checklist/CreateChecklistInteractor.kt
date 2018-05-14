package com.aim.atlas.core.interactor.checklist.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.entity.checklist.Checklist
import com.aim.atlas.core.entity.checklist.Step
import com.aim.atlas.core.mapper.checklist.ChecklistRequestMapper
import com.aim.atlas.core.mapper.checklist.ChecklistResponseMapper
import com.aim.atlas.core.repository.checklist.*
import com.aim.atlas.core.specification.checklist.ChecklistSpecification
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith
import javax.inject.Named

@TestOpen
@Named("create_checklist_interactor")
class CreateChecklistInteractor(
        private val checklistRepository: ChecklistRepository,
        private val configurationRepository: ConfigurationRepository,
        private val stepRepository: StepRepository,
        private val answerRepository: AnswerRepository,
        private val stepLabelRepository: StepLabelRepository,
        private val specification: ChecklistSpecification,
        private val requestMapper: ChecklistRequestMapper,
        private val responseMapper: ChecklistResponseMapper
) :
        InputBoundary<ChecklistRequest, CreateChecklistInteractor> {
    private lateinit var request: ChecklistRequest

    override fun input(input: ChecklistRequest): CreateChecklistInteractor {
        request = input
        return this
    }

    fun execute(): Maybe<ChecklistResponse> {
        return Observable.just(request)
                .map { requestMapper.transform(it) }
                .addConfiguration()
                .addSteps()
                .flatMapMaybe { checklistRepository.create(it) }
                .map { responseMapper.transform(it) }
                .singleElement()
    }

    fun broadcast(checkList: Checklist) {
        //TODO: Hacer que esto haga algo
    }

    private fun Observable<Checklist>.addConfiguration() =
            this.concatMap {
                Observable.just(it).zipWith(configurationRepository.create(it.configuration!!).toObservable())
            }
            .flatMap { (a,b) -> a.configuration = b; Observable.just(a) }

    private fun Observable<Checklist>.addSteps() =
            this.concatMap {
                Observable.just(it).zipWith(
                        Observable.fromIterable(it.steps)
                                .addAnswer()
                                .addStepLabels()
                                .flatMapMaybe { stepRepository.create(it) }
                                .toList()
                                .toObservable()
                )
                .flatMap { (a,b) -> a.steps = b; Observable.just(a) }
            }

    private fun Observable<Step>.addAnswer() =
            this.concatMap {
                Observable.just(it).zipWith(
                    Observable.just(it.answer)
                            .flatMapMaybe { answerRepository.create(it) }
                )
                .flatMap { (a,b) -> a.answer = b; Observable.just(a) }
            }

    private fun Observable<Step>.addStepLabels() =
            this.concatMap {
                Observable.just(it).zipWith(
                Observable.fromIterable(it.stepLabels)
                        .flatMapMaybe { stepLabelRepository.create(it) }
                        .toList()
                        .toObservable()
                )
                .flatMap { (a,b) -> a.stepLabels = b; Observable.just(a) }
            }
}
