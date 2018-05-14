package com.aim.atlas.core.events.organization

import com.aim.atlas.core.entity.membership.MemberType

class AccountCreatedEvent(){
        var accountId: Long? = null
        var userId: Long? = null
        var userName: String? = null
        var userEmail: String? = null
        var userMemberType: MemberType? = null
        private val originService: String? = null

    constructor(accountId: Long, userId: Long, userName: String, userEmail: String, userMemberType: String): this(){
        this.accountId = accountId
        this.userId = userId
        this.userName = userName
        this.userEmail = userEmail
        this.userMemberType = MemberType.valueOf(userMemberType)
    }

}