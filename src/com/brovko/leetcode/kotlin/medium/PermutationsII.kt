package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertContentEquals

class PermutationsII {
    val result = arrayListOf<List<Int>>()

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)

        permuteUniqueRecursively(nums, ArrayList(), BooleanArray(nums.size))

        return result
    }

    fun permuteUniqueRecursively(nums: IntArray, permutation: ArrayList<Int>, used: BooleanArray) {
        if(permutation.size == nums.size){
            result.add(ArrayList(permutation))
        } else {
            for (i in nums.indices) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue

                used[i] = true
                permutation.add(nums[i])
                permuteUniqueRecursively(nums, permutation, used)
                used[i] = false
                permutation.removeAt(permutation.lastIndex)
            }
        }
    }


    @Test
    fun test1(){
        assertContentEquals(
            listOf(
                listOf(1,1,2),
                listOf(1,2,1),
                listOf(2,1,1),
            ),
            permuteUnique(intArrayOf(1,1,2))
        )
    }

    @Test
    fun test2(){
        assertContentEquals(
            listOf(
                listOf(1,2,3),
                listOf(1,3,2),
                listOf(2,1,3),
                listOf(2,3,1),
                listOf(3,1,2),
                listOf(3,2,1),
            ),
            permuteUnique(intArrayOf(1,2,3))
        )
    }
    @Test
    fun test3(){
        assertContentEquals(
            listOf(
                listOf(0,3,3,3),
                listOf(3,0,3,3),
                listOf(3,3,0,3),
                listOf(3,3,3,0)
            ),
            permuteUnique(intArrayOf(3,3,0,3))
        )
    }
}