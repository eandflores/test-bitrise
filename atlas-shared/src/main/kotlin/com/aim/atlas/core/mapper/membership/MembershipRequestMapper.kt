package com.aim.atlas.core.mapper.membership

import com.aim.atlas.core.entity.membership.Membership
import com.aim.atlas.core.interactor.membership.membership.MembershipRequest
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class MembershipRequestMapper: Mapper<MembershipRequest, Membership> {
    override fun transform(source: MembershipRequest): Membership {
        return with(source){
            Membership(
                id = id,
                user = user!!,
                accountId = accountId,
                status = status,
                memberType = memberType
            )
        }
    }

}