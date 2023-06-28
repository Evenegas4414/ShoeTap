package com.ervr.shoetap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ShoeAdapter(private val dataSet: List<Shoe>) : RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {
    var listener: OnItemClickListener? = null

    constructor(dataSet: List<Shoe>, listener: OnItemClickListener?) : this(dataSet) {
        this.listener = listener
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shoe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = dataSet[position]
        holder.view.findViewById<TextView>(R.id.item_name).text = shoe.name
        holder.view.findViewById<TextView>(R.id.item_price).text = shoe.price.toString()
        Glide.with(holder.view.context).load(shoe.imageUrl).into(holder.view.findViewById(R.id.item_image))

        holder.itemView.setOnClickListener {
            listener?.onItemClick(shoe)
        }
    }

    override fun getItemCount() = dataSet.size

    interface OnItemClickListener {
        fun onItemClick(shoe: Shoe)
    }
}