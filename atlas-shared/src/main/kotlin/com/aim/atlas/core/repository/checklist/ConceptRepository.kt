package com.aim.atlas.core.repository.checklist

import com.aim.atlas.core.entity.checklist.Concept
import io.reactivex.Maybe

interface ConceptRepository {
    fun create(concept: Concept): Maybe<Concept>
    fun update(concept: Concept): Maybe<Concept>
    fun findById(id: Long): Maybe<Concept>
    fun findAllByChecklistId(checklistId: Long): Maybe<List<Concept>>
}