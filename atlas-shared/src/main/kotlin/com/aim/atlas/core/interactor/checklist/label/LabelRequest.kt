package com.aim.atlas.core.interactor.checklist.label

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class LabelRequest : RequestModel {
    var id: Long = 0L
    lateinit var name: String
    var place: Int? = 0
    var weight: Float = 0F
}