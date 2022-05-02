package ir.moris.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.moris.data.dao.UserInfoDao
import ir.moris.data.repository.UserRepositoryImpl
import ir.moris.domain.repositories.UserRepository
import ir.moris.domain.usecases.GetAllUsersUseCase
import ir.moris.domain.usecases.InsertUserUseCase
import ir.moris.domain.usecases.UserUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class commonModule {
    @Provides
    @Singleton
    fun providesUserInfoRepository(dao: UserInfoDao): UserRepository {
        return UserRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun providesUserUseCases(repository: UserRepository):UserUseCases{
        return UserUseCases(
            insertUserUseCase = InsertUserUseCase(repository),
            getAllUsersUseCase = GetAllUsersUseCase(repository)
        )
    }

}