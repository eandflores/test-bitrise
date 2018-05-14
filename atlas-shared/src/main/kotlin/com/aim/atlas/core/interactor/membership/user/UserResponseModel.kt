package com.aim.atlas.core.interactor.membership.user

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel

@TestOpen
class UserResponseModel(
        val id: Long,
        val name: String,
        val email: String,
        val password: String,
        val oktaId: String?) : ResponseModel