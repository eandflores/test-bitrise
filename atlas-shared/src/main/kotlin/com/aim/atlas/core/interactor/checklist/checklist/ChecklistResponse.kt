package com.aim.atlas.core.interactor.checklist.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel
import com.aim.atlas.core.interactor.checklist.concept.ConceptResponse
import com.aim.atlas.core.interactor.checklist.step.StepResponse
import java.time.LocalDateTime

@TestOpen
data class ChecklistResponse(
        val id: Long,
        val name: String,
        val description: String,
        val icon: String,
        val testMode: Boolean,
        val createdAt: LocalDateTime,
        val updatedAt: LocalDateTime,
        val concepts: List<ConceptResponse>,
        val steps: List<StepResponse>
): ResponseModel