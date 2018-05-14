package com.aim.atlas.core.interactor.organization.businessline

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.PaginationRequest
import com.aim.atlas.core.mapper.organization.BusinessLineResponseMapper
import com.aim.atlas.core.repository.organization.BusinessLineRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("get_business_line_by_business_areas")
class GetBusinessLineByBusinessAreaInteractor(
        private val repository: BusinessLineRepository,
        private val responseMapper: BusinessLineResponseMapper
) :
        MaybeInteractor<Pagination<BusinessLineResponse>>(),
        InputBoundary<PaginationRequest<List<Long>>, GetBusinessLineByBusinessAreaInteractor> {

    private lateinit var request: PaginationRequest<List<Long>>

    override fun input(input: PaginationRequest<List<Long>>): GetBusinessLineByBusinessAreaInteractor {
        this.request = input
        return this
    }

    override fun execute(): Maybe<Pagination<BusinessLineResponse>> {
        return repository.findAllByBusinessArea(request)
                .map { responseMapper.transform(it) }
    }
}
