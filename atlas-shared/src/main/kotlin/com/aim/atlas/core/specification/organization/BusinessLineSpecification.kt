package com.aim.atlas.core.specification.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.BusinessLine
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class BusinessLineSpecification : AbstractSpecification<BusinessLine>() {

    override fun isSatisfiedBy(candidate: BusinessLine): Boolean {
        return true
        TODO("Implement BusinessLineSpecification")
    }
}