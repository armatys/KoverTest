package com.example.kovertest

import org.junit.Assert.*
import org.junit.Test

class SampleTest {
    @Test
    fun test1() {
        assertEquals(1, Sample().add(0, 1))
        assertEquals(1, Sample().add(1, 0))
    }

    // Check by commenting out the test function below:
    @Test
    fun test2() {
        assertEquals(4, Sample().add(2, 2))
    }
}
