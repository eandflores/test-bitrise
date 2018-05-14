package com.aim.atlas.core.events.membership

import com.aim.atlas.core.entity.membership.User
import com.aim.atlas.core.events.EventBase
import com.aim.atlas.core.events.EventType

data class MembershipCreatedEvent(val accountId: Long, val user: User, private val originService: String) : EventBase(originService, EventType.CREATE) {
}