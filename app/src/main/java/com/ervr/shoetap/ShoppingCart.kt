package com.ervr.shoetap

object ShoppingCart {
    val shoeList = mutableListOf<Shoe>()

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
    }

    fun clear() {
        shoeList.clear()
    }
}
