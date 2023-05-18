package com.example.loginudf.data.repository

import com.example.loginudf.data.sources.ApiDataSourceMock

class UserRepository() : IUserRepository {
    private val apiDataSource = ApiDataSourceMock()

    override fun authenticateUser(email: String, password: String) =
        apiDataSource.validUsersInRemoteServer[email]?.let {
            if (it.password == password) it else null
        }

}