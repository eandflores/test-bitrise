package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.Category
import com.aim.atlas.core.interactor.checklist.category.CategoryRequest
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class CategoryRequestMapper: Mapper<CategoryRequest, Category> {
    override fun transform(source: CategoryRequest): Category {
        return Category(source.id!!).apply {
            name = source.name
            icon = source.icon
        }
    }

}