package com.cpu.app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.security.NoSuchAlgorithmException

import java.security.MessageDigest;
import java.util.*

@RestController
class HashController {

    @GetMapping("/hash/{input}")
    fun getDigest(@PathVariable("input") input: String): String? {
        var md5: String? = null
        for (i: Int in 1..100_000) {
            md5 = getMD5Digest(input)
        }
        return md5;
    }

    @GetMapping("/hello")
    fun hello(): String? {
        return "hello"
    }

    @Throws(NoSuchAlgorithmException::class)
    private fun getMD5Digest(input: String): String? {
        val md: MessageDigest = MessageDigest.getInstance("MD5")
        md.update(input.toByteArray())
        val digest: ByteArray = md.digest()
        return Base64.getEncoder().encodeToString(digest)
    }
}