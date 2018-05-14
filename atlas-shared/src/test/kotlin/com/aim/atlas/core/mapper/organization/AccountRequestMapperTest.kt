package com.aim.atlas.core.mapper.organization

import com.aim.atlas.core.entity.organization.Account
import com.aim.atlas.core.interactor.organization.account.CreateAccountRequest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AccountRequestMapperTest {
    lateinit var validAccount: CreateAccountRequest
    lateinit var invalidAccount: Account
    lateinit var mapper: CreateAccountRequestMapper

    @Before
    fun setUp() {
        validAccount = CreateAccountRequest("Walmart", "hola$(#! ¨** ", "123456")
        mapper = CreateAccountRequestMapper()
    }

    @Test
    fun transform() {
        val account = mapper.transform(validAccount)
        assertEquals("hola", account.subdomain)
    }

    @Test
    fun transform1() {
    }
}