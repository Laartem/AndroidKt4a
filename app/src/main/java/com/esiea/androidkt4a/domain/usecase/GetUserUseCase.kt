package com.esiea.androidkt4a.domain.usecase

import com.esiea.androidkt4a.data.repository.UserRepository
import com.esiea.androidkt4a.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User{
        return userRepository.getUser(email)

    }
}