package com.aim.atlas.core.repository.organization

import com.aim.atlas.core.entity.organization.Configuration
import com.aim.atlas.core.repository.Repository
import io.reactivex.Maybe
import javax.inject.Named

interface ConfigurationRepository : Repository {

    /** Create new [Configuration] */
    fun create(configuration: Configuration) : Maybe<Configuration>

    /** Update an [Configuration] */
    fun update(configuration: Configuration) : Maybe<Configuration>

    /** Get one [Configuration] from its id */
    fun find(id: Long) : Maybe<Configuration>
}