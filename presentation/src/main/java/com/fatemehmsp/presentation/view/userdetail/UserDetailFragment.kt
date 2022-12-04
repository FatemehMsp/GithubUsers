package com.fatemehmsp.presentation.view.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.fatemehmsp.domain.model.UserDomainModel
import com.fatemehmsp.domain.model.UserInfoDomainModel
import com.fatemehmsp.presentation.databinding.FragmentUserDetailBinding
import com.fatemehmsp.presentation.utils.exstension.autoCleared
import com.fatemehmsp.presentation.utils.exstension.load
import com.fatemehmsp.presentation.utils.exstension.visibleOrGone
import com.fatemehmsp.presentation.utils.openBrowser
import com.fatemehmsp.presentation.viewmodel.userdetail.UserDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private var binding by autoCleared<FragmentUserDetailBinding>()

    private val args by navArgs<UserDetailFragmentArgs>()

    private val viewModel : UserDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            fetchUserInfo(args.user)
            loading.observe(viewLifecycleOwner,::observeLoading)
            userInfo.observe(viewLifecycleOwner,::observeUserInfo)
            messenger.observe(viewLifecycleOwner,::observeMessenger)
        }

        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun observeUserInfo(userInfo: UserInfoDomainModel){
        binding.apply {
            txtLogin.text = userInfo.login
            txtName.text = userInfo.name
            txtBio.text = userInfo.bio
            imgAvatar.load(requireContext(),userInfo.avatarUrl)
            imgOpenBrowser.setOnClickListener {
                openBrowser(requireContext(),userInfo.htmlUrl)
            }
            txtFollowersValue.text = userInfo.followers
            txtFollowingsValue.text = userInfo.following
        }
    }

    private fun observeMessenger(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


    private fun observeLoading(isShow: Boolean) {
        binding.loading.visibleOrGone(isShow)
    }

}