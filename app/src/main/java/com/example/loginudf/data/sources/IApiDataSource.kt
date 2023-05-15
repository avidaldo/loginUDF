package com.example.loginudf.data.sources

import com.example.loginudf.data.model.User

interface IApiDataSource {
    fun authenticateUser(email: String, password: String): User?
}