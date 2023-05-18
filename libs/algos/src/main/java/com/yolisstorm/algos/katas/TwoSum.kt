package com.yolisstorm.algos.katas

/**
 * Given an array of integers [nums] and an integer [target],
 * return indices of the two numbers such that they add up to {target}.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * You can return the answer in any order.
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val negative = nums.map { target - it }
    negative.forEachIndexed { negativeIndex, negativeValue ->
        val positiveIndex = nums
            .mapIndexed { index, i -> index to i }
            .indexOfFirst { it.second == negativeValue && it.first != negativeIndex }
        if (positiveIndex >= 0)
            return intArrayOf(positiveIndex, negativeIndex)
    }
    return intArrayOf(-1, -1)
}

fun twoSumHash(nums: IntArray, target: Int): IntArray {
    val negativeList = nums.mapIndexed { index, value -> target - value to index }
    val negative = negativeList.toMap()
    val positive = nums.mapIndexed { index, value -> value to index }.toMap()
    negative.forEach { entry ->
        val positiveIndex = positive
                .filterKeys { it == entry.key }
                .filterValues { it != entry.value }
                .values
                .firstOrNull()
        if (positiveIndex != null && positiveIndex >= 0)
            return intArrayOf(positiveIndex, entry.value)
    }
    return intArrayOf(-1, -1)
}