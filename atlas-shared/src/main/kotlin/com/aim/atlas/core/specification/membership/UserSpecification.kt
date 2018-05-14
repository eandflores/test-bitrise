package com.aim.atlas.core.specification.membership

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.membership.User
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named


@TestOpen
@Named
class UserSpecification : AbstractSpecification<User>() {

    override fun isSatisfiedBy(candidate: User): Boolean {
        if(candidate.name!!.length < 3){
            return false
        }
        return true
    }

}