package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.ChecklistConfiguration
import com.aim.atlas.core.interactor.checklist.configuration.ConfigurationRequest
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class ConfigurationRequestMapper :
        Mapper<ConfigurationRequest, ChecklistConfiguration>{

    override fun transform(source: ConfigurationRequest): ChecklistConfiguration {
        return ChecklistConfiguration(source.id).apply {
            minGrade = source.minGrade
            maxGrade = source.maxGrade
            interval = source.interval
            executionTime = source.executionTime
            publicationTime = source.publicationTime
            expirationTime = source.expirationTime
            withVenue = source.withVenue
            withAsset = source.withAsset
            withService = source.withService
            tourConceptId = source.tourConceptId
            defaultConceptId = source.defaultConceptId
        }
    }
}