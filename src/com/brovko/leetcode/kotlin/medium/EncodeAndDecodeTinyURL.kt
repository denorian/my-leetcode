package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EncodeAndDecodeTinyURL {
    /**
    TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
    and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
    There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL
    can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
    Implement the Solution class:

    Solution() Initializes the object of the system.
    String encode(String longUrl) Returns a tiny URL for the given longUrl.
    String decode(String shortUrl) Returns the original long URL for the given shortUrl.
    It is guaranteed that the given shortUrl was encoded by the same object.
     */

    val tinyMap = HashMap<String, String>()
    val longMap = HashMap<String, String>()
    val dict = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    fun encode(longUrl: String): String {
        if (longMap.containsKey(longUrl)) {
            return longMap.get(longUrl) ?: ""
        }

        val hashBuider = StringBuilder("http://tinyurl.com/")
        for (i in 0 .. 6) {
            val random = (0..dict.length - 1).random()
            hashBuider.append(dict.get(random))
        }

        val hash = hashBuider.toString()
        tinyMap.put(hash, longUrl)
        longMap.put(longUrl, hash)

        return hash
    }

    fun decode(shortUrl: String): String {
        return tinyMap.getOrDefault(shortUrl, "")
    }

    @Test
    fun test1() {
        val url = "https://leetcode.com/problems/design-tinyurl"
        val tiny1 = encode(url)
        val tiny2 = encode(url)
        assertEquals(tiny1, tiny2)

        val ans1 = decode(tiny1)
        val ans2 = decode(tiny2)

        assertEquals(url, ans1)
        assertEquals(url, ans2)
    }
}