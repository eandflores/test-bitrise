package com.aim.atlas.core.specification.membership

import com.aim.atlas.core.entity.membership.Profile
import com.aim.atlas.core.entity.membership.User
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserSpecificationTest {
    lateinit var specification: UserSpecification
    lateinit var validUser: User
    lateinit var invalidNameUser: User

    @Before
    fun setUp() {
        specification = UserSpecification()
        validUser = User(2,"Juan", "juan@juan.com", null, "password",profile = Profile())
        invalidNameUser = User(2, "", "juan@juan.com",null, "password", profile = Profile())
    }

    @Test
    fun isSatisfiedBy() {
        assertEquals(true, specification.isSatisfiedBy(validUser))
    }

    @Test
    fun isNotSatisfiedByName() {
        assertEquals(false, specification.isSatisfiedBy(invalidNameUser))
    }
}