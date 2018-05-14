package com.aim.atlas.core.interactor.checklist.step

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class StepConditionerRequest : RequestModel {
    var id: Long = 0L
    var answerId: Long? = null
    lateinit var steps: List<Long>

}