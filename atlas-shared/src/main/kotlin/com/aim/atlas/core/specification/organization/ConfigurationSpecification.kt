package com.aim.atlas.core.specification.organization

import com.aim.atlas.core.annotations.TestOpen
import com.aim.atlas.core.entity.organization.Configuration
import com.aim.atlas.core.specification.AbstractSpecification
import javax.inject.Named

@TestOpen
@Named
class ConfigurationSpecification : AbstractSpecification<Configuration>() {

    override fun isSatisfiedBy(candidate: Configuration): Boolean {

        /** locale */
        val localePattern = Regex("[a-z]{2}-[A-Z]{2}$")

        if (!candidate.locale!!.matches(localePattern)) {
            return false
        }

//        /** primaryColor */
//        val colorPattern = Regex("")
//
//        if (!candidate.primaryColor!!.matches(colorPattern)) {
//            return false
//        }
//
//        /** secondaryColor */
//        if (!candidate.secondaryColor!!.matches(colorPattern)) {
//            return false
//        }

        return true
    }
}