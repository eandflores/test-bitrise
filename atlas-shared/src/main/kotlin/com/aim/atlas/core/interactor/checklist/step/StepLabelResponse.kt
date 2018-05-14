package com.aim.atlas.core.interactor.checklist.step

import com.aim.atlas.core.boundary.ResponseModel

class StepLabelResponse(
        val id: Long,
        val weight: Number,
        val place: Number,
        val labelId: Long
): ResponseModel