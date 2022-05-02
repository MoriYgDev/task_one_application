package ir.moris.domain.usecases

import androidx.lifecycle.MutableLiveData
import ir.moris.domain.models.UserInfoModel
import ir.moris.domain.repositories.UserRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {

    suspend operator fun invoke() : MutableList<UserInfoModel> {
        return userRepository.getAllUsers()
    }

}