package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
data class Step(
        val id: Long,
        var name: String? = null,
        var stepLabels: List<StepLabel>? = null,
        var answer: Answer? = null)