package com.example.loginudf.data.repository

import com.example.loginudf.data.model.User

interface IUserRepository {
    fun authenticateUser(email: String, password: String): User?
}