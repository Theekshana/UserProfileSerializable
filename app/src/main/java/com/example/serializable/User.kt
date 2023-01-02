package com.example.serializable

import java.io.Serializable

data class User (
    val profileImage: String,
    val name: String,
    val email: String,
    val age: String,
    val number: String

): Serializable