package com.fatemehmsp.data.datasource

import com.fatemehmsp.data.datasource.remote.UsersDataSource
import com.fatemehmsp.data.datasource.remote.UsersDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindUsersDataSource(usersDataSourceImp: UsersDataSourceImp):
            UsersDataSource
}

