package ir.moris.data.repository

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

    override fun getAllUsers(): MutableLiveData<MutableList<UserInfoModel>> {
        return MutableLiveData(
            dao.getAllUsers().value?.map {
                UserTypeConverter.fromUserInfo(it)
            }?.toMutableList()
        )
    }
}
