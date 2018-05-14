package com.aim.atlas.core.mapper.membership

import com.aim.atlas.core.entity.membership.Profile
import com.aim.atlas.core.entity.membership.User
import com.aim.atlas.core.events.organization.AccountCreatedEvent
import com.aim.atlas.core.interactor.membership.membership.MembershipRequest
import com.aim.atlas.core.mapper.Mapper

class MembershipEventRequestMapper : Mapper<AccountCreatedEvent, MembershipRequest> {
    override fun transform(source: AccountCreatedEvent): MembershipRequest {
        return  MembershipRequest().apply {
            accountId = source.accountId!!
            user = User(id = source.userId,
                    name = source.userName!!,
                    email = source.userEmail!!,
                    password = "",
                    profile = Profile())
        }
    }

}