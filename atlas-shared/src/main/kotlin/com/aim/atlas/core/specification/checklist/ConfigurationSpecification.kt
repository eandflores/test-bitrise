package com.aim.atlas.core.specification.checklist

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.checklist.ChecklistConfiguration
import com.aim.atlas.core.specification.AbstractSpecification
import java.time.LocalDateTime
import javax.inject.Named

@TestOpen
@Named
class ConfigurationSpecification: AbstractSpecification<ChecklistConfiguration>() {
    override fun isSatisfiedBy(candidate: ChecklistConfiguration): Boolean {
        /* MinGrade must be at least 0 */
        if (candidate.minGrade!! < 0) return false

        /* MaxGrade must be greater than MinGrade */
        if (candidate.maxGrade!! <= candidate.minGrade!!) return false

        /* Interval must be greater than 0 */
        if (candidate.interval!! <= 0) return false

        /* Interval must be equal or less than the difference between Max and Min Grades */
        if (candidate.interval!! > (candidate.maxGrade!! - candidate.minGrade!!)) return false

        /* Execution time must be greater than 0 */
        if (candidate.executionTime!! <= 0) return false

        /* Publication time must be greater than now */
        if (candidate.publicationTime!! <= LocalDateTime.now()) return false

        /* Expiration time must be greater than Publication time */
        if (candidate.expirationTime!! <= candidate.publicationTime) return false

        /* At least one of the following must be true */
        if (!(candidate.withService!! || candidate.withAsset!! || candidate.withVenue!!)) return false

        /* Tour and Default concept must not me null */
        if (candidate.tourConceptId == null || candidate.defaultConceptId == null) return false

        /* All good */
        return true
    }
}