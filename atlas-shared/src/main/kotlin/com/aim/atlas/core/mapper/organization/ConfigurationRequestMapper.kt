package com.aim.atlas.core.mapper.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Configuration
import com.aim.atlas.core.interactor.organization.configuration.ConfigurationRequest
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@TestOpen
@Named
class ConfigurationRequestMapper : Mapper<ConfigurationRequest, Configuration> {
    override fun transform(source: ConfigurationRequest): Configuration {
        return with(source) {
            Configuration(
                    id = id,
                    logo = logo!!,
                    locale = locale!!,
                    primaryColor = primaryColor!!,
                    secondaryColor = secondaryColor!!
            )
        }
    }

}