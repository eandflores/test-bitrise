package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.Step
import com.aim.atlas.core.interactor.checklist.step.StepResponse
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class StepResponseMapper(
        private val stepLabelMapper: StepLabelResponseMapper,
        private val answerMapper: AnswerResponseMapper
): Mapper<Step, StepResponse> {

    override fun transform(source: Step): StepResponse {
        return with(source) {
            StepResponse(
                    id,
                    name!!,
                    stepLabels!!.map { stepLabelMapper.transform(it) },
                    answerMapper.transform(answer!!)
            )
        }
    }
}