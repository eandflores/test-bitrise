package com.aim.atlas.core.events.organization

import com.aim.atlas.core.events.EventBase
import com.aim.atlas.core.events.EventType

data class AccountEnabledEvent(val accountId: Long, private val originService: String) : EventBase(originService, EventType.ENABLE) {
}