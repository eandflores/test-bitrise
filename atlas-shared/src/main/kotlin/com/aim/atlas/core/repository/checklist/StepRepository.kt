package com.aim.atlas.core.repository.checklist

import com.aim.atlas.core.entity.checklist.Step
import io.reactivex.Maybe

interface StepRepository {
    fun create(step: Step): Maybe<Step>
    fun update(step: Step): Maybe<Step>
    fun findById(id: Long): Maybe<Step>
}