package com.aim.atlas.core.interactor.checklist.answer

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel
import com.aim.atlas.core.entity.checklist.Answer
import com.aim.atlas.core.interactor.checklist.step.StepConditionerRequest
import com.aim.atlas.core.valueObjects.Trilean

@TestOpen
class AnswerRequest : RequestModel {
    var id: Long = 0L
    var isGraded: Boolean = true
    var allowNA: Boolean = true
    lateinit var umbralOperator: String
    var umbralValue: Int? = 0
    var description: Trilean = Trilean.OPTIONAL
    var attachment: Trilean = Trilean.OPTIONAL
    var picture: Trilean = Trilean.OPTIONAL
    var gps: Trilean = Trilean.REQUIRED
    var stepConditioners: List<StepConditionerRequest> = listOf()

    var isMultiple: Boolean = false
    var options: List<OptionRequest>? = null
}