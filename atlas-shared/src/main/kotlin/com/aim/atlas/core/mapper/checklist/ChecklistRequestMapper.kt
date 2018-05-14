package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Checklist
import com.aim.atlas.core.entity.checklist.Concept
import com.aim.atlas.core.interactor.checklist.checklist.ChecklistRequest
import com.aim.atlas.core.mapper.Mapper
import com.aim.atlas.core.repository.checklist.ConceptRepository
import javax.inject.Named

@TestOpen
@Named
class ChecklistRequestMapper(
        private val conceptRepository: ConceptRepository,
        private val stepMapper: StepRequestMapper,
        private val configurationMapper: ConfigurationRequestMapper
    ):
        Mapper<ChecklistRequest, Checklist>{

    override fun transform(source: ChecklistRequest): Checklist {
        return Checklist().apply {
            name = source.name
            description = source.description
            icon = source.icon
            testMode = source.testMode
            concepts = source.concepts.map { conceptRepository.findById(it).blockingGet() }
            steps = stepMapper.transform(source.steps)
            configuration = configurationMapper.transform(source.configuration)
        }
    }

}