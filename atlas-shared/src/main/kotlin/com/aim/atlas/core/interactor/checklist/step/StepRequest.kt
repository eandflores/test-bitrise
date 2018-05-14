package com.aim.atlas.core.interactor.checklist.step

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel
import com.aim.atlas.core.interactor.checklist.answer.AnswerRequest

@TestOpen
class StepRequest : RequestModel {
    var id: Long = 0L
    lateinit var name: String
    lateinit var stepLabels: List<StepLabelRequest>
    lateinit var answer: AnswerRequest
}