package com.aim.atlas.core.repository.checklist

import com.aim.atlas.core.entity.checklist.Category
import com.aim.atlas.core.entity.checklist.Checklist
import io.reactivex.Maybe

interface CategoryRepository {
    fun findById(id: Long): Maybe<Category>
    fun findAllByBusinessAreaId(businessAreaId: Long): Maybe<List<Category>>
    fun create(category: Category): Maybe<Category>
    fun update(category: Category): Maybe<Category>
    fun delete(category: Category): Maybe<Category>
    fun assignChecklist(category: Category, checklist: Checklist): Maybe<Category>
    fun removeChecklist(category: Category, checklist: Checklist): Maybe<Category>
}