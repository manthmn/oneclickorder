package com.food.ordering.oneclickorder.data.model

import com.google.gson.annotations.SerializedName

data class VerifyOrderResponse(
        @SerializedName("orderId")
        val orderId: Int,
        @SerializedName("transactionToken")
        val transactionToken: String
)