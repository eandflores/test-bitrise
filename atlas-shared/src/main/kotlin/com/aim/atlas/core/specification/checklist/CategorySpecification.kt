package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.Category
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class CategorySpecification : AbstractSpecification<Category>() {
    override fun isSatisfiedBy(candidate: Category): Boolean {
        return true;
    }
}