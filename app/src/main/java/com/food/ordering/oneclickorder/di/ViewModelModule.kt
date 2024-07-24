package com.food.ordering.oneclickorder.di

import com.food.ordering.oneclickorder.ui.cart.CartViewModel
import com.food.ordering.oneclickorder.ui.contributors.ContributorViewModel
import com.food.ordering.oneclickorder.ui.home.HomeViewModel
import com.food.ordering.oneclickorder.ui.login.LoginViewModel
import com.food.ordering.oneclickorder.ui.order.OrderViewModel
import com.food.ordering.oneclickorder.ui.otp.OtpViewModel
import com.food.ordering.oneclickorder.ui.payment.PaymentViewModel
import com.food.ordering.oneclickorder.ui.placeorder.PlaceOrderViewModel
import com.food.ordering.oneclickorder.ui.profile.ProfileViewModel
import com.food.ordering.oneclickorder.ui.restaurant.RestaurantViewModel
import com.food.ordering.oneclickorder.ui.search.SearchViewModel
import com.food.ordering.oneclickorder.ui.signup.SignUpViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { OtpViewModel(get()) }
    viewModel { RestaurantViewModel(get()) }
    viewModel { SignUpViewModel(get(), get()) }
    viewModel { ProfileViewModel(get(), get(),get()) }
    viewModel { SearchViewModel(get(), get()) }
    viewModel { OrderViewModel(get()) }
    viewModel { CartViewModel(get()) }
    viewModel { PlaceOrderViewModel(get()) }
    viewModel { PaymentViewModel(get()) }
    viewModel { ContributorViewModel() }
}