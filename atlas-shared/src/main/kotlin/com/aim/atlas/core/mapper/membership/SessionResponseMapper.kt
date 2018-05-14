package com.aim.atlas.core.mapper.membership

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.membership.Session
import com.aim.atlas.core.interactor.membership.user.SessionResponseModel
import com.aim.atlas.core.mapper.Mapper
import javax.inject.Named

@TestOpen
@Named
class SessionResponseMapper :
        Mapper<Session, SessionResponseModel> {

    override fun transform(source: Session): SessionResponseModel =
            with(source){
                SessionResponseModel(
                        access_token = access_token,
                        expires_in = expires_in
                )
            }
}