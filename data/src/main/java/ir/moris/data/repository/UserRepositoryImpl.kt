package ir.moris.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.moris.data.dao.UserInfoDao
import ir.moris.data.mapper.UserTypeConverter
import ir.moris.domain.models.UserInfoModel
import ir.moris.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl(
    private val dao : UserInfoDao
): UserRepository {
    override suspend fun insertUser(userInfoModel: UserInfoModel) {
        dao.insertUserInfo(UserTypeConverter.toUserInfo(userInfoModel))
    }

    override suspend fun getAllUsers(): MutableList<UserInfoModel> {
        return dao.getAllUsers().map {
            it.toDomain()
        }.toMutableList()
    }
}
