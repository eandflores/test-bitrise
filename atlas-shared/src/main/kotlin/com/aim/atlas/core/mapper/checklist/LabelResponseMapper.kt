package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Label
import com.aim.atlas.core.interactor.checklist.label.LabelResponse
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@TestOpen
@Named
class LabelResponseMapper: Mapper<Label, LabelResponse> {
    override fun transform(source: Label): LabelResponse {
        return with(source) {
            LabelResponse(
                    id,
                    name!!,
                    place!!,
                    weight!!
            )
        }
    }

}