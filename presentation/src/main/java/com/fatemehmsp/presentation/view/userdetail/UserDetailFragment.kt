package com.fatemehmsp.presentation.view.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.fatemehmsp.domain.model.UserDomainModel
import com.fatemehmsp.presentation.databinding.FragmentUserDetailBinding
import com.fatemehmsp.presentation.utils.exstension.autoCleared
import com.fatemehmsp.presentation.utils.exstension.load
import com.fatemehmsp.presentation.utils.openBrowser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private var binding by autoCleared<FragmentUserDetailBinding>()

    private val args by navArgs<UserDetailFragmentArgs>()

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

        setupView(args.user)
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupView(user: UserDomainModel) {
        binding.apply {
            txtName.text = user.login
            imgAvatar.load(requireContext(),user.avatarUrl)
            imgOpenBrowser.setOnClickListener {
                openBrowser(requireContext(),user.url)
            }
            txtFollowers.setOnClickListener {
                openBrowser(requireContext(),user.followersUrl)
            }
            txtFollowings.setOnClickListener {
                openBrowser(requireContext(),user.followingUrl)
            }
        }
    }
}