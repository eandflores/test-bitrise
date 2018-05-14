package com.aim.atlas.core.events.membership

import com.aim.atlas.core.events.EventBase
import com.aim.atlas.core.events.EventType

data class UserCreatedEvent(val accountId: Long, val userName: String, val userEmail: String, private val originService: String) : EventBase(originService, EventType.CREATE) {

}