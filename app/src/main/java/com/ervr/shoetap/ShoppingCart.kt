package com.ervr.shoetap

import android.content.Context

class ShoppingCart(context: Context) {
    private val prefs = context.getSharedPreferences("MY_APP", Context.MODE_PRIVATE)

    fun addItem(shoe: Shoe) {
        val editor = prefs.edit()
        editor.putInt(shoe.name, prefs.getInt(shoe.name, 0) + 1)
        editor.apply()
    }

    fun removeItem(shoe: Shoe) {
        val editor = prefs.edit()
        val currentQuantity = prefs.getInt(shoe.name, 0)
        if (currentQuantity > 0) {
            editor.putInt(shoe.name, currentQuantity - 1)
        }
        editor.apply()
    }

    fun getCartContents(): Map<String, *> {
        return prefs.all
    }
}