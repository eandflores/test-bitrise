package com.aim.atlas.core.interactor.checklist.answer

import com.aim.atlas.core.boundary.ResponseModel
import com.aim.atlas.core.valueObjects.Trilean

abstract class AnswerResponse(
        val id: Long,
        val isGraded: Boolean,
        val allowNA: Boolean,
        val umbralOperator: String,
        val umbralValue: Int,
        val description: Trilean,
        val attachment: Trilean,
        val picture: Trilean,
        val gps: Trilean
): ResponseModel