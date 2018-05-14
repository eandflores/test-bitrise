package com.aim.atlas.core.interactor.checklist.label

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel

@TestOpen
class LabelResponse(
    val id: Long,
    val name: String,
    val place: Int,
    val weight: Float
): ResponseModel