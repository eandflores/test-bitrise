package com.aim.atlas.core.entity.checklist

import com.aim.atlas.core.annotations.TestOpen

@TestOpen
data class StepConditioner(
        val id: Long,
        var steps: List<Long>? = null,
        var answerId: Long? = null
    )
