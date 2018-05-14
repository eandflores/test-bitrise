package com.aim.atlas.core.interactor.checklist.concept

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel
import com.aim.atlas.core.interactor.checklist.label.LabelResponse

@TestOpen
class ConceptResponse(
        val id: Long,
        val name: String,
        val color: String,
        val isPonderated: Boolean,
        val labels: List<LabelResponse>
): ResponseModel