package ir.moris.data.mapper

import ir.moris.data.entity.UserInfo
import ir.moris.domain.models.UserInfoModel

object UserTypeConverter {
    fun toUserInfo( userInfoModel: UserInfoModel) : UserInfo{
        return UserInfo(
            userInfoModel.id,
            userInfoModel.phoneNumber,
            userInfoModel.password
        )
    }

    fun fromUserInfo(userInfo: UserInfo):UserInfoModel{
        return UserInfoModel(
            userInfo.id,
            userInfo.phoneNumber,
            userInfo.password
        )
    }
}