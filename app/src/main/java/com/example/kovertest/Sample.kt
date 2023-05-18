package com.example.kovertest

class Sample {
    fun add(x: Int, y: Int): Int {
        if (x == 0) {
            return y
        }

        // Check by commenting out the block below:
        if (y == 0) {
            return x
        }

        return x + y
    }
}
