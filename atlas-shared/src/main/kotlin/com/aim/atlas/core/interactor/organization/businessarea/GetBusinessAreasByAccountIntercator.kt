package com.aim.atlas.core.interactor.organization.businessarea

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.mapper.organization.BusinessAreaResponseMapper
import com.aim.atlas.core.repository.organization.BusinessAreaRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("get_business_areas_by_account_interactor")
class GetBusinessAreasByAccountIntercator(
        private val repository: BusinessAreaRepository,
        private val mapper: BusinessAreaResponseMapper
) :
        MaybeInteractor<Pagination<BusinessAreaResponse>>(),
        InputBoundary<PaginationRequest<Long>, GetBusinessAreasByAccountIntercator> {

    private lateinit var request: PaginationRequest<Long>

    override fun input(input: PaginationRequest<Long>): GetBusinessAreasByAccountIntercator {
        request = input
        return this
    }

    override fun execute(): Maybe<Pagination<BusinessAreaResponse>> {
        return repository.findAllByAccountId(request)
                .map{ mapper.transform(it)}
    }
}