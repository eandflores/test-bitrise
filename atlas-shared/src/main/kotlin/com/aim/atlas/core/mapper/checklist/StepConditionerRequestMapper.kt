package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.StepConditioner
import com.aim.atlas.core.interactor.checklist.step.StepConditionerRequest
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class StepConditionerRequestMapper :
        Mapper<StepConditionerRequest, StepConditioner>,
        ListMapper<StepConditionerRequest, StepConditioner> {

    override fun transform(source: StepConditionerRequest): StepConditioner {
        return StepConditioner(source.id).apply {
            steps = source.steps
            answerId = source.answerId
        }
    }

    override fun transform(source: List<StepConditionerRequest>): List<StepConditioner> {
        return source.map { this.transform(it) }
    }


}