package ir.moris.taskoneapplication.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.moris.domain.models.UserInfoModel
import ir.moris.domain.usecases.UserUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {

    var databaseContent = MutableLiveData<MutableList<UserInfoModel>>()

    init {
        getAllUsers()
    }

    fun getAllUsers(){
            databaseContent = userUseCases.getAllUsersUseCase()
    }

    fun signIn(userInfoModel: UserInfoModel){
        viewModelScope.launch {
            userUseCases.insertUserUseCase(
                userInfoModel
            )
            Log.d("ViewModel" , "ViewModel added $userInfoModel")
        }
    }

}