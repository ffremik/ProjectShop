package com.example.projectmoon.view.basket.data

enum class Order(val time: Long, val status: String) {
    PLACING_AN_ORDER(10000L, "Оформление заказа"),
    TRANSFERRED_OR_DELIVERY(14000L, "Передано в доставку"),
    ON_THE_WAY(15000L, "В пути"),
    DELIVERY(3000,"Доставлено")
}