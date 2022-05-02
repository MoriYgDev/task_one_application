package ir.moris.data.dao

import androidx.lifecycle.MutableLiveData
import androidx.room.*
import ir.moris.data.entity.UserInfo
import ir.moris.domain.models.UserInfoModel

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserInfo(userInfo : UserInfo)

    @Query("Select * from userinfo")
    fun getAllUsers(): MutableLiveData<MutableList<UserInfo>>

}