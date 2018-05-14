package com.aim.atlas.core.specification.membership

import com.aim.atlas.core.entity.membership.Session
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@Named
class SessionSpecification : AbstractSpecification<Session>() {

    override fun isSatisfiedBy(candidate: Session): Boolean {
       return true
    }
}