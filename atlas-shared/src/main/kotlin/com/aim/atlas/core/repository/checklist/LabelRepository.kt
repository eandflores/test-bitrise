package com.aim.atlas.core.repository.checklist

import com.aim.atlas.core.entity.checklist.Label
import io.reactivex.Maybe

interface LabelRepository {
    fun create(label: Label): Maybe<Label>
    fun update(label: Label): Maybe<Label>
    fun findById(id: Long): Maybe<Label>
}