package com.aim.atlas.core.interactor.organization.configuration

import com.aim.atlas.core.boundary.ResponseModel

class ConfigurationResponse(
        val id: Long,
        val logo: String,
        val locale: String,
        val primaryColor: String,
        val secondaryColor: String
) : ResponseModel