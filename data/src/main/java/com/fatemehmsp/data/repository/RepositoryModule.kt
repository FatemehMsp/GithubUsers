package com.fatemehmsp.data.repository

import com.fatemehmsp.domain.repository.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindUsersRepository(usersRepositoryImp: UsersRepositoryImp):
            UsersRepository
}