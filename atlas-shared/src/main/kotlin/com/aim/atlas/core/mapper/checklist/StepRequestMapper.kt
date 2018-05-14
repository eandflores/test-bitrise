package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.Step
import com.aim.atlas.core.interactor.checklist.step.StepRequest
import com.aim.atlas.core.mapper.ListMapper
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class StepRequestMapper(
        private val answerMapper: AnswerRequestMapper,
        private val stepLabelRequestMapper: StepLabelRequestMapper
) : Mapper<StepRequest, Step>, ListMapper<StepRequest, Step> {

    override fun transform(source: StepRequest): Step {
        return Step(source.id).apply {
            name = source.name
            stepLabels = source.stepLabels.map { stepLabelRequestMapper.transform(it) }
            answer = answerMapper.transform(source.answer)
        }
    }

    override fun transform(source: List<StepRequest>): List<Step> {
        return source.map { this.transform(it) }
    }
}