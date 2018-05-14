package com.aim.atlas.core.mapper.membership

import com.aim.atlas.core.events.organization.AccountCreatedEvent
import com.aim.atlas.core.interactor.Pagination
import com.aim.atlas.core.interactor.membership.user.UserRequestModel
import com.aim.atlas.core.mapper.Mapper

class UserEventRequestMapper : Mapper<AccountCreatedEvent, UserRequestModel> {
    override fun transform(source: AccountCreatedEvent): UserRequestModel {
        return UserRequestModel().apply {
            id = source.userId
            name = source.userName
            email = source.userEmail
        }
    }
}