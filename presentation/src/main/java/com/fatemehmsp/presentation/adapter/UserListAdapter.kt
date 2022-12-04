package com.fatemehmsp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.fatemehmsp.domain.model.UserDomainModel
import com.fatemehmsp.presentation.databinding.RowUserListBinding

class UserListAdapter(val adapterOnClick: (UserDomainModel) -> Unit) :
    ListAdapter<UserDomainModel, UserListAdapter.ViewHolder>(VENUE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.ViewHolder =
        ViewHolder(
            RowUserListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: UserListAdapter.ViewHolder, position: Int) {
        getItem(position)?.also {
            holder.onBind(it)
        }
    }


    companion object {
        private val VENUE_COMPARATOR = object : DiffUtil.ItemCallback<UserDomainModel>() {
            override fun areItemsTheSame(
                oldItem: UserDomainModel,
                newItem: UserDomainModel
            ): Boolean =
                oldItem.id == newItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: UserDomainModel,
                newItem: UserDomainModel
            ): Boolean =
                newItem == oldItem
        }
    }


    inner class ViewHolder(private val binding: RowUserListBinding) :
        BaseViewHolder<UserDomainModel>(binding) {

        override fun onBind(item: UserDomainModel) {
            binding.txtLogin.text = item.login

            binding.parent.setOnClickListener {
                adapterOnClick.invoke(item)
            }
        }

    }
}