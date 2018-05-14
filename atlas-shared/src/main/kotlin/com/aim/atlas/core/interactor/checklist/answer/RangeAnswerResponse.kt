package com.aim.atlas.core.interactor.checklist.answer

import com.aim.atlas.core.valueObjects.Trilean

class RangeAnswerResponse(
        id: Long,
        isGraded: Boolean,
        allowNA: Boolean,
        umbralOperator: String,
        umbralValue: Int,
        description: Trilean,
        attachment: Trilean,
        picture: Trilean,
        gps: Trilean
): AnswerResponse(
        id,
        isGraded,
        allowNA,
        umbralOperator,
        umbralValue,
        description,
        attachment,
        picture,
        gps
)