package com.aim.atlas.core.valueObjects

import com.aim.atlas.core.throwable.InvalidEmailException
import org.junit.Test

import org.junit.Assert.*

class EmailTest {

    @Test(expected = InvalidEmailException::class)
    fun invalidEmail() {
        Email("BadEmail")
    }

    @Test
    fun validEmail(){
        var email = Email("comida@gmail.com")
        assertEquals(email.value, "comida@gmail.com")
    }
}