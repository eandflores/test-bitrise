package com.aim.atlas.core.mapper.membership

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.membership.Profile
import com.aim.atlas.core.entity.membership.User
import com.aim.atlas.core.interactor.membership.user.UserRequestModel
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@TestOpen
@Named
class UserRequestMapper : Mapper<UserRequestModel, User> {
    override fun transform(source: UserRequestModel): User {
        return with(source){
            User(id = source.id,
                name = source.name!!,
                email = source.email!!,
                oktaId = source.oktaId,
                password = source.password!!,
                profile = source.profile!!)
        }
    }
}