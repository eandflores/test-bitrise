package com.aim.atlas.core.repository.checklist

import com.aim.atlas.core.entity.checklist.StepLabel
import io.reactivex.Maybe

interface StepLabelRepository {
    fun create(stepLabel: StepLabel): Maybe<StepLabel>
    fun update(stepLabel: StepLabel): Maybe<StepLabel>
    fun delete(id: Long): Maybe<Void>
}