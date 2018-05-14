package com.aim.atlas.core.interactor.organization.businessline

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.mapper.organization.BusinessLineResponseMapper
import com.aim.atlas.core.repository.organization.BusinessLineRepository
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("get_businessline_by_account_id")
class GetBusinessLineByAccountIdInteractor(
        private val repository: BusinessLineRepository,
        private val responseMapper: BusinessLineResponseMapper
) :
        MaybeInteractor<Pagination<BusinessLineResponse>>(),
        InputBoundary<PaginationRequest<Long>, GetBusinessLineByAccountIdInteractor> {

    private lateinit var request: PaginationRequest<Long>

    override fun input(input: PaginationRequest<Long>): GetBusinessLineByAccountIdInteractor {
        this.request = input
        return this
    }


    override fun execute(): Maybe<Pagination<BusinessLineResponse>> {
        return repository.findAllByAccountId(request)
                .map { responseMapper.transform(it) }
    }
}