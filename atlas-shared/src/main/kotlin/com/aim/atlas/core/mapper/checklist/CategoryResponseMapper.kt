package com.aim.atlas.core.mapper.checklist

import com.aim.atlas.core.entity.checklist.Category
import com.aim.atlas.core.interactor.checklist.category.CategoryResponse
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class CategoryResponseMapper: Mapper<Category, CategoryResponse> {
    override fun transform(source: Category): CategoryResponse {
        return CategoryResponse(
                id = source.id,
                name = source.name!!,
                icon = source.icon!!,
                businessAreaId = source.businessAreaId!!
        )
    }
}