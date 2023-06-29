package com.ervr.shoetap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ShoeAdapter(
    private val dataSet: List<Shoe>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val shoeImage: ImageView = view.findViewById(R.id.product_image)
        val shoeName: TextView = view.findViewById(R.id.product_name)
        val shoePrice: TextView = view.findViewById(R.id.product_price)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(dataSet[position])
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(shoe: Shoe)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.shoe_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe: Shoe = dataSet[position]

        holder.shoeName.text = shoe.name
        holder.shoePrice.text = shoe.price.toString()

        Glide.with(holder.view.context)
            .load(shoe.image)
            .into(holder.shoeImage)
    }

    override fun getItemCount() = dataSet.size
}
