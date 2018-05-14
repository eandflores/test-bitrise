package com.aim.atlas.core.interactor.organization.businessarea

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.entity.organization.BusinessArea
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.organization.BusinessAreaRequestMapper
import com.aim.atlas.core.mapper.organization.BusinessAreaResponseMapper
import com.aim.atlas.core.repository.organization.BusinessAreaRepository
import com.aim.atlas.core.specification.organization.BusinessAreaSpecification
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("create_business_area_interactor")
class CreateBusinessAreaInteractor(
        private val repository: BusinessAreaRepository,
        private val requestMapper: BusinessAreaRequestMapper,
        private val specification: BusinessAreaSpecification,
        private val responseMapper: BusinessAreaResponseMapper
) :
        MaybeInteractor<BusinessAreaResponse>(),
        InputBoundary<BusinessAreaRequest, CreateBusinessAreaInteractor> {

    private lateinit var request: BusinessAreaRequest

    override fun execute(): Maybe<BusinessAreaResponse> {
        return Maybe.just(request)
                .map{ requestMapper.transform(it)}
                .filter { specification.isSatisfiedBy(it) }
                .flatMap { repository.create(it) }
                .filter { specification.isSatisfiedBy(it)}
                .doOnSuccess({ broadcast(it) })
                .map { responseMapper.transform(it) }
    }

    override fun input(input: BusinessAreaRequest): CreateBusinessAreaInteractor {
        request = input
        return this
    }

    fun broadcast(businessArea: BusinessArea) {
        //Gotta write something here
    }
}