package com.fatemehmsp.presentation.viewmodel.userdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatemehmsp.domain.model.UserDomainModel
import com.fatemehmsp.domain.model.UserInfoDomainModel
import com.fatemehmsp.domain.request.UserInfoRequest
import com.fatemehmsp.domain.request.UserRequest
import com.fatemehmsp.domain.usecase.userinfo.UserInfoUseCase
import com.fatemehmsp.presentation.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userInfoUseCase: UserInfoUseCase
):ViewModel() {

    private val _userInfo = MutableLiveData<UserInfoDomainModel>()
    val userInfo : LiveData<UserInfoDomainModel> = _userInfo

    private val _messenger = SingleLiveData<String>()
    val messenger: LiveData<String> = _messenger

    private val _loading = MutableLiveData<Boolean>(false)
    val loading = _loading


    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        Log.e(TAG,error.message.toString())
        //_messenger.value = error.message   //handle errors
        _loading.value = false
    }

    fun fetchUserInfo(userDomainModel: UserDomainModel) {
        _loading.value = true
        _userInfo.value = UserInfoDomainModel(
            id = userDomainModel.id,
            login = userDomainModel.login,
            bio = "",
            name = "",
            avatarUrl = userDomainModel.avatarUrl,
            url = userDomainModel.url,
            htmlUrl = userDomainModel.htmlUrl,
            followers = "",
            following = ""
        )
        viewModelScope.launch(exceptionHandler) {
            _userInfo.value = getUserInfo(userDomainModel.url)
            _loading.value = false
        }
    }

    private suspend fun getUserInfo(url: String):UserInfoDomainModel =
        withContext(Dispatchers.IO){
            userInfoUseCase.invoke(UserInfoRequest(url))
        }


    companion object {
        private const val TAG = "COROUTINE_EXCEPTION_TAG"
    }
}