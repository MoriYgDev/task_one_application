package ir.moris.domain.repositories

import androidx.lifecycle.MutableLiveData
import ir.moris.domain.models.UserInfoModel

interface UserRepository {
    suspend fun insertUser(userInfoModel: UserInfoModel)
    suspend fun getAllUsers(): MutableList<UserInfoModel>
}