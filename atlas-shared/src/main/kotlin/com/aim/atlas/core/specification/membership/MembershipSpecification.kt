package com.aim.atlas.core.specification.membership

import com.aim.atlas.core.entity.membership.Membership
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@Named
class MembershipSpecification : AbstractSpecification<Membership>() {

    override fun isSatisfiedBy(candidate: Membership): Boolean {
       return true
    }
}