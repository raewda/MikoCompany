package com.example.mikocompany.dcl

import java.util.Date

data class AcceptanceClass(
    val id : Int,
    val date : String,
    val price : Float,
    val full_count : Int
){
    companion object{

        val one = AcceptanceClass(0, "25.03.2025", 5000.0F, 150)

        val ordersAll = mutableListOf(
            one
        )

        fun getById(id: Int): AcceptanceClass {
            ordersAll.forEach() { el ->
                if (el.id == id) return el
            }
            return one
        }
    }
}
