package com.fatemehmsp.presentation.view.userList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatemehmsp.domain.model.UserDomainModel
import com.fatemehmsp.presentation.adapter.UserListAdapter
import com.fatemehmsp.presentation.databinding.FragmentUserListBinding
import com.fatemehmsp.presentation.utils.PaginationScrollListener
import com.fatemehmsp.presentation.utils.exstension.autoCleared
import com.fatemehmsp.presentation.utils.exstension.visibleOrGone
import com.fatemehmsp.presentation.viewmodel.userlist.UserListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserListFragment : Fragment() , ActivityCompat.OnRequestPermissionsResultCallback {

    private val viewModel : UserListViewModel by viewModels()

    private var binding by autoCleared<FragmentUserListBinding>()

    private lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            loading.observe(viewLifecycleOwner,::observeLoading)
            loadingPaging.observe(viewLifecycleOwner,::observeLoadingPaging)
            userList.observe(viewLifecycleOwner,::observeUserList)
            messenger.observe(viewLifecycleOwner,::observeMessenger)
        }

        userListAdapter = UserListAdapter {
            openUserDetailFragment(it)
        }

        setupUserList()

    }

    private fun setupUserList() {
        binding.userList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userListAdapter

            addOnScrollListener(object : PaginationScrollListener(
                layoutManager as LinearLayoutManager
            ) {
                override fun isLoading(): Boolean =
                    viewModel.loadingPaging.value!!

                override fun loadMoreItems() {
                    viewModel.loadMoreUsers()
                }

            })
        }
    }

    private fun observeUserList(venues : List<UserDomainModel>){
        venues.let {
            userListAdapter.submitList(it)
        }
    }

    private fun observeMessenger(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun observeLoadingPaging(isShow: Boolean) {
        binding.loadingPaging.visibleOrGone(isShow)
    }

    private fun observeLoading(isShow: Boolean) {
        binding.loading.visibleOrGone(isShow)
    }

    private fun openUserDetailFragment(user: UserDomainModel){
        val args = UserListFragmentDirections.toUserDetail(user)
        findNavController().navigate(args)
    }

}