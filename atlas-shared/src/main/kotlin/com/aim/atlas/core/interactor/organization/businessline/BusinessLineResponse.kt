package com.aim.atlas.core.interactor.organization.businessline

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.ResponseModel

@TestOpen
class BusinessLineResponse(val id: Long,
                           val name: String,
                           val alias: String,
                           val description: String,
                           val accountId: Long,
                           val configurationId: Long) : ResponseModel