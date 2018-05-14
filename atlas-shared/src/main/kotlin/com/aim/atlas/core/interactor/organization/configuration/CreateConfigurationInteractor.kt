package com.aim.atlas.core.interactor.organization.configuration

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.entity.organization.Configuration
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.organization.ConfigurationRequestMapper
import com.aim.atlas.core.mapper.organization.ConfigurationResponseMapper
import com.aim.atlas.core.repository.organization.ConfigurationRepository
import com.aim.atlas.core.specification.organization.ConfigurationSpecification
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named("configuration")
class CreateConfigurationInteractor(
        private val repository: ConfigurationRepository,
        private val specification: ConfigurationSpecification,
        private val requestMapperCreate: ConfigurationRequestMapper,
        private val responseMapper: ConfigurationResponseMapper
) :
        MaybeInteractor<ConfigurationResponse>(),
        InputBoundary<ConfigurationRequest, CreateConfigurationInteractor> {
    private lateinit var request : ConfigurationRequest

    override fun input(input: ConfigurationRequest): CreateConfigurationInteractor{
        request = input
        return this
    }

    override fun execute(): Maybe<ConfigurationResponse> {
        return Maybe.just(request)
                .map { requestMapperCreate.transform(it) }
                .filter { specification.isSatisfiedBy(it) }
                .flatMap { repository.create(it) }
                .filter { specification.isSatisfiedBy(it) }
                .doOnSuccess{ broadcast(it) }
                .map { responseMapper.transform(it) }
    }

    fun broadcast(configuration: Configuration) {
    }
}