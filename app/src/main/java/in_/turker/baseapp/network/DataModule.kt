package in_.turker.baseapp.network

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Kerem TÜRKER on 4.03.2022.
 */

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {
    @Binds
    abstract fun bindAPIClientImpl(impl: APIClientImpl): APIClient
}