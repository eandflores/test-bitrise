package com.aim.atlas.core.interactor.checklist.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.entity.checklist.Checklist
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.mapper.checklist.ChecklistRequestMapper
import com.aim.atlas.core.mapper.checklist.ChecklistResponseMapper
import com.aim.atlas.core.repository.checklist.ChecklistRepository
import com.aim.atlas.core.specification.checklist.ChecklistSpecification
import io.reactivex.Flowable
import javax.inject.Named

@TestOpen
@Named
class UpdateChecklistInteractor(
        private var repository: ChecklistRepository,
        private var requestMapper: ChecklistRequestMapper,
        private var responseMapper: ChecklistResponseMapper,
        private var specification: ChecklistSpecification
) :
        Interactor<ChecklistResponse>(),
        InputBoundary<ChecklistRequest, UpdateChecklistInteractor>{

    private lateinit var request: ChecklistRequest

    override fun input(input: ChecklistRequest): UpdateChecklistInteractor {
        request = input
        return this
    }

    override fun execute(): Flowable<ChecklistResponse> {
        return Flowable.just(request)
                .map{ requestMapper.transform(it) }
                .filter{ specification.isSatisfiedBy(it) }
                .flatMap { repository.update(it) }
                .doOnNext{ broadcast(it) }
                .map{ responseMapper.transform(it) }
    }

    fun broadcast(checkList: Checklist) {
        //TODO: Hacer que esto haga algo
    }
}
