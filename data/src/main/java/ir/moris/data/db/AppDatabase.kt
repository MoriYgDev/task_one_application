package ir.moris.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.moris.data.dao.UserInfoDao
import ir.moris.data.entity.UserInfo

@Database(entities = [UserInfo::class] , version = 1 , exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract val dao : UserInfoDao

    companion object{
        const val DB_NAME = "user_info_database"
    }
}