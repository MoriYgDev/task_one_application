package ir.moris.domain.repositories

import androidx.lifecycle.MutableLiveData
import ir.moris.domain.models.UserInfoModel

interface UserRepository {
    suspend fun insertUser(userInfoModel: UserInfoModel)
    fun getAllUsers(): MutableLiveData<MutableList<UserInfoModel>>
}