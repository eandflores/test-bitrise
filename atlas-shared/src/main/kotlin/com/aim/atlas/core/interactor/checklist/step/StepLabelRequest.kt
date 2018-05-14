package com.aim.atlas.core.interactor.checklist.step

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class StepLabelRequest: RequestModel {
    var id: Long = 0L
    var labelId: Long? = null
    var place: Int = 0
    var weight: Float = 0F
}