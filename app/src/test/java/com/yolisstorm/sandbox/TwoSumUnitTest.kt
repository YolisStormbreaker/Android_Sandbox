package com.yolisstorm.sandbox

import com.yolisstorm.algos.katas.twoSum
import com.yolisstorm.algos.katas.twoSumHash
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

internal class TwoSumUnitTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun twoSumNegativeListTest(nums: IntArray, target: Int, expected: IntArray) {
        val result = twoSum(
            nums = nums,
            target = target
        ).sortedArray()
        assertArrayEquals(expected.sortedArray(), result)
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun twoSumHashTest(nums: IntArray, target: Int, expected: IntArray) {
        val result = twoSumHash(
            nums = nums,
            target = target
        ).sortedArray()
        assertArrayEquals(expected.sortedArray(), result)
    }

    private companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(2,7,11,15), 9, intArrayOf(0,1)),
                Arguments.of(intArrayOf(3,2,4), 6, intArrayOf(1,2)),
                Arguments.of(intArrayOf(3,3), 6, intArrayOf(0,1)),
                Arguments.of(intArrayOf(-1,-2,-3,-4,-5), -8, intArrayOf(2,4)),
                Arguments.of(intArrayOf(3,2,95,4,-3), 92, intArrayOf(2,4)),
            )
    }

}