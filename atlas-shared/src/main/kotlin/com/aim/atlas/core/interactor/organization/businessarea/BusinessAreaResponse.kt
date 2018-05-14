package com.aim.atlas.core.interactor.organization.businessarea

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel
import com.aim.atlas.core.interactor.organization.account.AccountResponse

@TestOpen
class BusinessAreaResponse(
    val id: Long,
    val name: String,
    val accountId: Long,
    val businessLinesIds: List<Long>) : ResponseModel
