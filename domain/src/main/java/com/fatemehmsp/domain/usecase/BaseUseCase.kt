package com.fatemehmsp.domain.usecase

interface BaseUseCase<I,O> {

   suspend fun invoke(input : I) : O
}