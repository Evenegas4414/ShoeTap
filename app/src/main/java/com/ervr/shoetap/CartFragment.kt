package com.ervr.shoetap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button

class CartFragment : Fragment() {
    private val shoppingCart: ShoppingCart = ShoppingCart

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.cart_recycler_view)
        val clearCartButton: Button = view.findViewById(R.id.clear_cart_button)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = ShoeAdapter(shoppingCart.shoeList, object : ShoeAdapter.OnItemClickListener {
            override fun onItemClick(shoe: Shoe) {
                // No action needed
            }
        })

        clearCartButton.setOnClickListener {
            shoppingCart.clear()
            recyclerView.adapter?.notifyDataSetChanged()
        }

        return view
    }
}