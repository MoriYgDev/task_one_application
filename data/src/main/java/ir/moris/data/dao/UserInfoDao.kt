package ir.moris.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ir.moris.data.entity.UserInfo

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserInfo(userInfo : UserInfo)

    @Query("Select * from userinfo")
    suspend fun getAllUsers(): MutableList<UserInfo>

}