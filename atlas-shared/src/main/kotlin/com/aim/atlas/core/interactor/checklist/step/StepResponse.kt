package com.aim.atlas.core.interactor.checklist.step

import com.aim.atlas.core.boundary.ResponseModel
import com.aim.atlas.core.interactor.checklist.answer.AnswerResponse

class StepResponse(
        val id: Long,
        val name: String,
        val stepLabels: List<StepLabelResponse>,
        val answer: AnswerResponse
): ResponseModel