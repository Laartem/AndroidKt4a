package com.esiea.androidkt4a.domain.usecase

import com.esiea.androidkt4a.data.repository.UserRepository
import com.esiea.androidkt4a.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)

    }
}