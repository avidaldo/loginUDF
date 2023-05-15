package com.example.loginudf.data.sources

import com.example.loginudf.data.model.User

class ApiDataSourceMock : IApiDataSource {

    override fun authenticateUser(email: String, password: String) =
        validUsersInRemoteServer[email]?.apply {
            if (this.password == password) this else null }


    private var validUsersInRemoteServer = mapOf(
        "pepe@pepe.com" to User("pepe@pepe.com", "12345678", "Pepe"),
        "abc@abc.abc" to User("abc@abc.abc", "12345678", "Torcuato"),
    )

}
