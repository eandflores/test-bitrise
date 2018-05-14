package com.aim.atlas.core.specification.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.BusinessArea
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class BusinessAreaSpecification: AbstractSpecification<BusinessArea>(){
    override fun isSatisfiedBy(candidate: BusinessArea): Boolean {
        if(candidate.name!!.length !in 3..50){
            return false
        }
        return true
    }
}
