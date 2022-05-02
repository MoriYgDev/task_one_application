package ir.moris.domain.usecases

import androidx.lifecycle.MutableLiveData
import ir.moris.domain.models.UserInfoModel
import ir.moris.domain.repositories.UserRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {

    operator fun invoke() : MutableLiveData<MutableList<UserInfoModel>>{
        return userRepository.getAllUsers()
    }

}