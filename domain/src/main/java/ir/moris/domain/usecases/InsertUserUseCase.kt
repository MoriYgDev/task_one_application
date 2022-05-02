package ir.moris.domain.usecases

import ir.moris.domain.models.UserInfoModel
import ir.moris.domain.repositories.UserRepository
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(userInfoModel: UserInfoModel){
        userRepository.insertUser(userInfoModel)
    }
}