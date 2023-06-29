package com.ervr.shoetap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class ProductFragment : Fragment() {
    private val shoppingCart = ShoppingCart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shoeImage: ImageView = view.findViewById(R.id.product_image)
        val shoeName: TextView = view.findViewById(R.id.product_name)
        val shoePrice: TextView = view.findViewById(R.id.product_price)
        val addButton: Button = view.findViewById(R.id.add_to_cart_button)

        val shoe = arguments?.getParcelable<Shoe>("shoe")

        if (shoe != null) {
            Glide.with(this)
                .load(shoe.image)
                .into(shoeImage)

            shoeName.text = shoe.name
            shoePrice.text = shoe.price.toString()

            addButton.setOnClickListener {
                shoppingCart.addShoe(shoe)
            }
        }
    }
}