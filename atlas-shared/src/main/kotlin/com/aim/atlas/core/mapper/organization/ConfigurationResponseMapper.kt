package com.aim.atlas.core.mapper.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.interactor.organization.configuration.ConfigurationResponse
import com.aim.atlas.core.entity.organization.Configuration
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.mapper.PaginationMapper
import javax.inject.Named

@TestOpen
@Named
class ConfigurationResponseMapper : Mapper<Configuration, ConfigurationResponse> {


    override fun transform(source: Configuration): ConfigurationResponse {
        return with(source) {
            ConfigurationResponse(
                    id = id,
                    logo = logo!!,
                    locale = locale!!,
                    primaryColor = primaryColor!!,
                    secondaryColor = secondaryColor!!
            )
        }
    }

}