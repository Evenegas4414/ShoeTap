package com.ervr.shoetap

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CartFragment : Fragment() {

    private lateinit var cartItems: MutableList<Shoe>
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = activity?.getSharedPreferences("cart", Context.MODE_PRIVATE)!!
        cartItems = retrieveCartItems()

        val recyclerView: RecyclerView = view.findViewById(R.id.cart_recycler_view)
        recyclerView.adapter = ShoeAdapter(cartItems)  // No pasamos un listener aquí
        recyclerView.layoutManager = LinearLayoutManager(context)

        val clearCartButton: Button = view.findViewById(R.id.clear_cart_button)
        clearCartButton.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            cartItems.clear()
            recyclerView.adapter?.notifyDataSetChanged()
        }

        val cartItems = (activity as MainActivity).shoppingCart
    }

    private fun retrieveCartItems(): MutableList<Shoe> {
        val gson = Gson()
        val json = sharedPreferences.getString("cart", "")
        val type = object : TypeToken<List<Shoe>>() {}.type
        return gson.fromJson(json, type) ?: mutableListOf()
    }
}

