package com.aim.atlas.core.interactor.organization.businessline

import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.entity.organization.BusinessLine
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.organization.BusinessLineRequestMapper
import com.aim.atlas.core.mapper.organization.BusinessLineResponseMapper
import com.aim.atlas.core.repository.organization.BusinessLineRepository
import com.aim.atlas.core.specification.organization.BusinessLineSpecification
import io.reactivex.Flowable
import io.reactivex.Maybe

class UpdateBusinessLineInteractor(
        private val repository: BusinessLineRepository,
        private val specification: BusinessLineSpecification,
        private val requestMapper: BusinessLineRequestMapper,
        private val responseMapper: BusinessLineResponseMapper
) :
        MaybeInteractor<BusinessLineResponse>(),
        InputBoundary<BusinessLineRequest, UpdateBusinessLineInteractor> {

    private lateinit var request: BusinessLineRequest

    override fun input(input: BusinessLineRequest): UpdateBusinessLineInteractor {
        request = input
        return this
    }

    override fun execute(): Maybe<BusinessLineResponse> {
        return Maybe.just(request)
                .map { requestMapper.transform(it) }
                .filter { specification.isSatisfiedBy(it) }
                .flatMap { repository.update(it) }
                .filter { specification.isSatisfiedBy(it) }
                .doOnSuccess{ broadcast(it) }
                .map { responseMapper.transform(it) }
    }

    fun broadcast(businessline: BusinessLine) {

    }
}