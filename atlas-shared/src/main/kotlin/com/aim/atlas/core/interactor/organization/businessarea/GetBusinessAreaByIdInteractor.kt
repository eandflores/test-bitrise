package com.aim.atlas.core.interactor.organization.businessarea

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.organization.BusinessAreaResponseMapper
import com.aim.atlas.core.repository.organization.BusinessAreaRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named
class GetBusinessAreaByIdInteractor(
        private val repository: BusinessAreaRepository,
        private val responseMapper: BusinessAreaResponseMapper
):
        MaybeInteractor<BusinessAreaResponse>(),
        InputBoundary<Long, GetBusinessAreaByIdInteractor> {

    private var request: Long = 0

    override fun execute(): Maybe<BusinessAreaResponse> {
        return Maybe.just(request)
                .flatMap { repository.find(it) }
                .map { responseMapper.transform(it) }
    }

    override fun input(input: Long): GetBusinessAreaByIdInteractor {
        request = input
        return this
    }


}