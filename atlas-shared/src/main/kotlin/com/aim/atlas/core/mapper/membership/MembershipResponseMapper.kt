package com.aim.atlas.core.mapper.membership

import com.aim.atlas.core.entity.membership.Membership
import com.aim.atlas.core.interactor.membership.membership.MembershipResponse
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@Named
class MembershipResponseMapper : Mapper<Membership, MembershipResponse> {
    override fun transform(source: Membership): MembershipResponse {
        return with(source){
            MembershipResponse(
                id = id,
                user = user,
                accountId = accountId,
                status = status,
                memberType = memberType
            )
        }
    }
}