package com.aim.atlas.core.interactor.checklist.concept

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel
import com.aim.atlas.core.interactor.checklist.label.LabelRequest

@TestOpen
class ConceptRequest : RequestModel {
    var id: Long = 0L
    lateinit var name: String
    lateinit var color: String
    var isPonderated: Boolean = true
    lateinit var labels: List<LabelRequest>
}