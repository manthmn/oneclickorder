package com.food.ordering.oneclickorder.ui.order

import com.food.ordering.oneclickorder.data.model.OrderStatusModel

data class OrderStatus(
        var isDone: Boolean = false,
        var isCurrent: Boolean = false,
        var name: String,
        var orderStatusList: List<OrderStatusModel> = listOf()
)
