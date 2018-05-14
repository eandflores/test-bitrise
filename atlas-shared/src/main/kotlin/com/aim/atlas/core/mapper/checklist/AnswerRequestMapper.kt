package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.Answer
import com.aim.atlas.core.entity.checklist.MultipleChoiceAnswer
import com.aim.atlas.core.entity.checklist.RangeAnswer
import com.aim.atlas.core.interactor.checklist.answer.AnswerRequest
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class AnswerRequestMapper(private val stepConditionerMapper: StepConditionerRequestMapper) : Mapper<AnswerRequest, Answer> {
    override fun transform(source: AnswerRequest): Answer {
        if (source.isMultiple) {
            return MultipleChoiceAnswer(source.id).apply {
                isGraded = source.isGraded
                allowNA = source.allowNA
                umbralOperator = source.umbralOperator
                umbralValue = source.umbralValue
                description = source.description
                attachment = source.attachment
                picture = source.picture
                gps = source.gps
                stepConditioners = stepConditionerMapper.transform(source.stepConditioners)
            }
        }

        return RangeAnswer(source.id).apply {
            isGraded = source.isGraded
            allowNA = source.allowNA
            umbralOperator = source.umbralOperator
            umbralValue = source.umbralValue
            description = source.description
            attachment = source.attachment
            picture = source.picture
            gps = source.gps
        }
    }
}