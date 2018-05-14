package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.StepLabel
import com.aim.atlas.core.interactor.checklist.step.StepLabelResponse
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class StepLabelResponseMapper: Mapper<StepLabel, StepLabelResponse> {
    override fun transform(source: StepLabel): StepLabelResponse {
        return with(source) {
            StepLabelResponse(
                    id,
                    weight!!,
                    place!!,
                    label!!.id
            )
        }
    }

}