package ir.moris.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.moris.domain.models.UserInfoModel

@Entity
data class UserInfo(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "phone_number")
    val phoneNumber : Long,
    @ColumnInfo(name = "password")
    val password : String
){
    companion object {
        fun fromDomain(id : Int = 0 , phoneNumber: Long , password: String) : UserInfo{
            return UserInfo(id, phoneNumber, password)
        }
    }

    fun toDomain() : UserInfoModel{
        return UserInfoModel(id, phoneNumber, password)
    }
}
