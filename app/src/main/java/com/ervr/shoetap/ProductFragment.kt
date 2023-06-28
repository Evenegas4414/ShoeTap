package com.ervr.shoetap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class ProductFragment : Fragment() {
    lateinit var shoe: Shoe

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        shoe = arguments?.getParcelable("shoe")!!

        view.findViewById<TextView>(R.id.product_name).text = shoe.name
        view.findViewById<TextView>(R.id.product_price).text = shoe.price.toString()
        Glide.with(view.context).load(shoe.imageUrl).into(view.findViewById(R.id.product_image))

        view.findViewById<Button>(R.id.add_to_cart_button).setOnClickListener {
            ShoppingCart(requireContext()).addItem(shoe)
            Toast.makeText(requireContext(), "Item añadido al carrito", Toast.LENGTH_SHORT).show()
        }

        val addButton: Button = view.findViewById(R.id.add_to_cart_button)
        addButton.setOnClickListener {
            (activity as MainActivity).addToCart(shoe)
    }

}
}