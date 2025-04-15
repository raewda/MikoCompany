package com.example.mikocompany.dcl


open class CategoryClass(
    val id : Int,
    val warehouse_code : Int,
    val name : String,
    val description : String,
    val price : Float,
    val count : Int,
    val supplier : String
){
    companion object{
        val one = CategoryClass(0, 1, "category1", "full", 170F, 200, "supplier1")
        val two = CategoryClass(0, 2, "category2", "full", 20F, 1000, "supplier2")

        val categoryAll = mutableListOf(
            one, two
        )

        fun getById(id: Int): CategoryClass {
            categoryAll.forEach() { el ->
                if (el.id == id) return el
            }
            return CategoryClass.one
        }

    }
}
