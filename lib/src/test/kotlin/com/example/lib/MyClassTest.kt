package com.example.lib

import org.junit.Assert.assertEquals
import org.junit.Test

class MyClassTest {
    @Test
    fun firstTest() {
        assertEquals(3, MyClass().add(1, 2))
    }
}
