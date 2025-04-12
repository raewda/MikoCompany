package com.example.mikocompany.dcl

open class NavRouts(
    val id : Int,
    val name : String,
    val translate : String
){
    companion object{
        val acceptance = NavRouts(0, "acceptance", "поставки")
        val category = NavRouts(1, "category", "категории")
        val offer = NavRouts(2, "offer", "предложения")
        val order = NavRouts(3, "order", "заказы")
        val statistic = NavRouts(4, "statistic", "статистика")
        val applicationInfo = NavRouts(5, "applicationInfo", "о приложении")
        val employees = NavRouts(6, "employees", "сотрудники")

        val routsAll = mutableListOf(
            acceptance, category, offer, order, statistic, applicationInfo, employees
        )

        fun getById(id : Int): NavRouts{
            routsAll.forEach() { el ->
                if (el.id == id) return el
            }
            return acceptance
        }
    }
}