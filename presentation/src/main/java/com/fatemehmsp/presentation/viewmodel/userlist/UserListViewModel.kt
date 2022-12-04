package com.fatemehmsp.presentation.viewmodel.userlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatemehmsp.domain.model.UserDomainModel
import com.fatemehmsp.domain.request.UserRequest
import com.fatemehmsp.domain.usecase.users.GetUsersUseCase
import com.fatemehmsp.presentation.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject


@HiltViewModel
class UserListViewModel @Inject constructor(
    private val usersUseCase: GetUsersUseCase,
) : ViewModel() {

    private val _userList = MutableLiveData<List<UserDomainModel>>()
    val userList : LiveData<List<UserDomainModel>> = _userList

    private val _messenger = SingleLiveData<String>()
    val messenger: LiveData<String> = _messenger

    private val _loading = MutableLiveData<Boolean>(false)
    val loading = _loading

    private val _loadingPaging = MutableLiveData<Boolean>(false)
    val loadingPaging = _loadingPaging

    private var since = 1

    private val exceptionHandler = CoroutineExceptionHandler { _, error ->
        Log.e(TAG,error.message.toString())
        //_messenger.value = error.message   //handle errors
        _loading.value = false
        _loadingPaging.value = false
    }

    init {
        viewModelScope.launch(exceptionHandler) {
            _loading.value = true
            _userList.value = getUserList()
            since += PER_PAGE
            _loading.value = false
        }
    }

   fun loadMoreUsers() {
       viewModelScope.launch(exceptionHandler) {
           _loadingPaging.value = true
           _userList.value = _userList.value?.plus(getUserList())?: emptyList()
           since += PER_PAGE
           _loadingPaging.value = false
       }
   }

    private suspend fun getUserList():List<UserDomainModel> =
        withContext(Dispatchers.IO){
            usersUseCase.invoke(UserRequest(since, PER_PAGE))
        }


    companion object {
        private const val PER_PAGE = 30
        private const val TAG = "COROUTINE_EXCEPTION_TAG"
    }
}