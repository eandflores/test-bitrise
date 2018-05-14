package com.aim.atlas.core.repository.checklist

import com.aim.atlas.core.entity.checklist.ChecklistConfiguration
import io.reactivex.Maybe

interface ConfigurationRepository {
    fun create(configuration: ChecklistConfiguration): Maybe<ChecklistConfiguration>
    fun update(configuration: ChecklistConfiguration): Maybe<ChecklistConfiguration>
}