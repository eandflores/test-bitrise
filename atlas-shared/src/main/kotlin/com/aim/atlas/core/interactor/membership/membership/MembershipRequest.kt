package com.aim.atlas.core.interactor.membership.membership

import com.aim.atlas.core.entity.membership.MemberType
import com.aim.atlas.core.entity.membership.MembershipStatus
import com.aim.atlas.core.entity.membership.User

class MembershipRequest {
    var user: User? = null
    var accountId: Long = 0
    var id: Long = 0
    var status = MembershipStatus.PENDING
    var memberType =  MemberType.VIEWER
}