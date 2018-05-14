package com.aim.atlas.core.interactor.organization.configuration

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel

@TestOpen
class ConfigurationRequest : RequestModel {
    var id: Long = 0
    var logo: String? = null
    var locale: String? = null
    var primaryColor: String? = null
    var secondaryColor: String? = null
}