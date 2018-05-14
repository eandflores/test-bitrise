package com.aim.atlas.core.interactor.checklist.configuration

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.boundary.RequestModel
import java.time.LocalDateTime
import javax.inject.Named


class ConfigurationRequest() : RequestModel {
    var id: Long = 0L
    var minGrade: Int = 0
    var maxGrade: Int = 100
    var interval: Int = 1
    var executionTime: Int = 60
    lateinit var publicationTime: LocalDateTime
    lateinit var expirationTime: LocalDateTime
    var withVenue: Boolean = true
    var withAsset: Boolean = false
    var withService: Boolean = false
    var tourConceptId: Long? = null
    var defaultConceptId: Long? = null
}