package com.aim.atlas.core.interactor.checklist.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.checklist.ChecklistResponseMapper
import com.aim.atlas.core.repository.checklist.ChecklistRepository
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("get_checklist_by_id_interactor")
class GetChecklistByIdInteractor(
        private var repository: ChecklistRepository,
        private var responseMapper: ChecklistResponseMapper
) :
        MaybeInteractor<ChecklistResponse>(),
        InputBoundary<Long, GetChecklistByIdInteractor> {

    private var request: Long = 0

    override fun input(input: Long): GetChecklistByIdInteractor {
        request = input
        return this
    }

    override fun execute(): Maybe<ChecklistResponse> {
        return Maybe.just(request)
                .flatMap { repository.find(it) }
                .map { responseMapper.transform(it)}
    }

}