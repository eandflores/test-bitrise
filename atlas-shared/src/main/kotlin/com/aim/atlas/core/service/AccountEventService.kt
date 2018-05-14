package com.aim.atlas.core.service

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.events.organization.AccountCreatedEvent


interface AccountEventService {

    /**
     * Notifies when an organization was created
     */
    fun onAccountEventCreated(accountCreatedEvent: AccountCreatedEvent)
    
    /**
     * Notify when an organization was enabled
     */
    fun accountEnabled(account: Account)

}