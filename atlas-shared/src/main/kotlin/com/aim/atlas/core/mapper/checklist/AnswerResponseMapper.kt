package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.Answer
import com.aim.atlas.core.entity.checklist.RangeAnswer
import com.aim.atlas.core.interactor.checklist.answer.AnswerResponse
import com.aim.atlas.core.interactor.checklist.answer.RangeAnswerResponse
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class AnswerResponseMapper: Mapper<Answer, AnswerResponse> {
    override fun transform(source: Answer): AnswerResponse {
        return with(source) {
            when(source) {
                is RangeAnswer -> RangeAnswerResponse(
                        id,
                        isGraded!!,
                        allowNA!!,
                        umbralOperator!!,
                        umbralValue!!,
                        description!!,
                        attachment!!,
                        picture!!,
                        gps!!
                )
                else -> RangeAnswerResponse( // Multiple Choice answer
                        id,
                        isGraded!!,
                        allowNA!!,
                        umbralOperator!!,
                        umbralValue!!,
                        description!!,
                        attachment!!,
                        picture!!,
                        gps!!
                )
            }
        }
    }
}