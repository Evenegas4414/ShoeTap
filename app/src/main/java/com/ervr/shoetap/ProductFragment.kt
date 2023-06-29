package com.ervr.shoetap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        val shoe = arguments?.getParcelable<Shoe>("shoe")

        val productName: TextView = view.findViewById(R.id.product_name)
        val productPrice: TextView = view.findViewById(R.id.product_price)
        val productImage: ImageView = view.findViewById(R.id.product_image_detail)
        val addToCartButton: Button = view.findViewById(R.id.add_to_cart_button)

        productName.text = shoe?.name
        productPrice.text = "$" + shoe?.price.toString()


        shoe?.image?.let {
            Glide.with(this)
                .load(shoe?.image)
                .error(R.drawable.ic_launcher_foreground) // Establece una imagen de error desde tus recursos drawable
                .into(productImage)
        }

        addToCartButton.setOnClickListener {
            shoe?.let { it1 -> shoppingCart.addShoe(it1) }
            findNavController().navigate(R.id.cartFragment)
        }
    }
}
