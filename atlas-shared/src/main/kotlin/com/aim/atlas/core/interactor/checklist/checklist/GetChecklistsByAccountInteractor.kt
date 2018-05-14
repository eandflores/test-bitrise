package com.aim.atlas.core.interactor.checklist.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.mapper.checklist.ChecklistResponseMapper
import com.aim.atlas.core.repository.checklist.ChecklistRepository
import io.reactivex.Flowable
import javax.inject.Named

@TestOpen
@Named
class GetChecklistsByAccountInteractor(
        private var repository: ChecklistRepository,
        private var responseMapper: ChecklistResponseMapper
) :
        Interactor<Pagination<ChecklistResponse>>(),
        InputBoundary<PaginationRequest<Long>, GetChecklistsByAccountInteractor> {
    private lateinit var request: PaginationRequest<Long>

    override fun input(input: PaginationRequest<Long>): GetChecklistsByAccountInteractor {
        request = input
        return this
    }

    override fun execute(): Flowable<Pagination<ChecklistResponse>> {
        return repository.findByAccountId(request)
                .map { responseMapper.transform(it) }
    }
}

