package com.aim.atlas.core.interactor.organization.configuration

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.InputBoundary
import com.aim.atlas.core.interactor.Interactor
import com.aim.atlas.core.interactor.MaybeInteractor
import com.aim.atlas.core.mapper.organization.ConfigurationResponseMapper
import com.aim.atlas.core.repository.organization.ConfigurationRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Named

@TestOpen
@Named
class GetConfigurationByIdInteractor(
        private val repository: ConfigurationRepository,
        private val responseMapper: ConfigurationResponseMapper
) :
        MaybeInteractor<ConfigurationResponse>(),
        InputBoundary<Long, GetConfigurationByIdInteractor> {

    private var request: Long = 0

    override fun input(input: Long): GetConfigurationByIdInteractor {
        request = input
        return this
    }

    override fun execute(): Maybe<ConfigurationResponse> {
        return Maybe.just(request)
                .flatMap { repository.find(it) }
                .map { responseMapper.transform(it) }
    }
}