package com.aim.atlas.core.interactor.organization.businessline

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.organization.BusinessLineResponseMapper
import com.aim.atlas.core.repository.organization.BusinessLineRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("get_businessline_by_id")
class GetBusinessLineByIdInteractor(
        private val repository: BusinessLineRepository,
        private val responseMapper: BusinessLineResponseMapper
) :
        MaybeInteractor<BusinessLineResponse>(),
        InputBoundary<Long, GetBusinessLineByIdInteractor> {

    private var request: Long = 0

    override fun input(input: Long): GetBusinessLineByIdInteractor {
        request = input
        return this
    }

    override fun execute(): Maybe<BusinessLineResponse> {
        return Maybe.just(request)
                .flatMap { repository.find(it) }
                .map { responseMapper.transform(it) }
    }
}