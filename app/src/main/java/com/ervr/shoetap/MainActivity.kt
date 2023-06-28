package com.ervr.shoetap

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity(), ShoeAdapter.OnItemClickListener {

    var shoppingCart: MutableList<Shoe> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadShoppingCart()
        // Cargar el fragmento de la lista de zapatos al inicio
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ShoeListFragment())
            .commit()

        val viewCartButton: Button = findViewById(R.id.view_cart_button)


        viewCartButton.setOnClickListener {
            val cartFragment = CartFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, cartFragment)
                .addToBackStack(null)
                .commit()
        }
    }


    override fun onItemClick(shoe: Shoe) {
        val productFragment = ProductFragment().apply {
            arguments = Bundle().apply {
                putParcelable("shoe", shoe)
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, productFragment)
            .addToBackStack(null)
            .commit()
    }

    fun addToCart(shoe: Shoe) {
        shoppingCart.add(shoe)
        saveShoppingCart()
    }

    fun clearCart() {
        shoppingCart.clear()
        saveShoppingCart()
    }

    private fun loadShoppingCart() {
        val sharedPreferences = getSharedPreferences("cart", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("cart", "")
        val type = object : TypeToken<List<Shoe>>() {}.type
        shoppingCart = gson.fromJson(json, type) ?: mutableListOf()
    }

    private fun saveShoppingCart() {
        val sharedPreferences = getSharedPreferences("cart", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(shoppingCart)
        editor.putString("cart", json)
        editor.apply()
    }
}