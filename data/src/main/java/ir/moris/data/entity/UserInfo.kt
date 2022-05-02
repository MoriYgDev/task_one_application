package ir.moris.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInfo(
    @PrimaryKey(autoGenerate = true)
    val id : Int?,
    @ColumnInfo(name = "phone_number")
    val phoneNumber : Long,
    @ColumnInfo(name = "password")
    val password : String
)
