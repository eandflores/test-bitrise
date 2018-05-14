package com.aim.atlas.core.interactor.membership.membership

import com.aim.atlas.core.boundary.ResponseModel
import com.aim.atlas.core.entity.membership.MemberType
import com.aim.atlas.core.entity.membership.MembershipStatus
import com.aim.atlas.core.entity.membership.User

class MembershipResponse(
        val id: Long,
        val user: User?,
        val accountId: Long?,
        val status: MembershipStatus,
        val memberType: MemberType) : ResponseModel