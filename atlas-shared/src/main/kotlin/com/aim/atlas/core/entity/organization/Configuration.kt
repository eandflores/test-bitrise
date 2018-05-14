package com.aim.atlas.core.entity.organization

class Configuration(val id: Long) {
    var logo: String? = null
    var locale: String? = null
    var primaryColor: String? = null
    var secondaryColor: String? = null

    constructor(id: Long, logo: String, locale: String, primaryColor: String, secondaryColor: String) : this(id) {
        this.logo = logo
        this.locale = locale
        this.primaryColor = primaryColor
        this.secondaryColor = secondaryColor
    }
}