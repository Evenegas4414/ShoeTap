package com.ervr.shoetap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoeListFragment : Fragment(), ShoeAdapter.OnItemClickListener {

    private val shoppingCart = ShoppingCart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shoe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        val shoeList = returnShoeList()

        recyclerView.adapter = ShoeAdapter(shoeList, this)
    }

    override fun onItemClick(shoe: Shoe) {
        val productFragment = ProductFragment().apply {
            arguments = Bundle().apply {
                putParcelable("shoe", shoe)
            }
        }
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.nav_host_fragment, productFragment)
            ?.addToBackStack(null)
            ?.commit()
    }

    private fun returnShoeList(): List<Shoe> {
        var url =
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/89afa6a48d7d4732b8daaead00ed1b45_9366/Start_Your_Run_Shoes_Black_GY9234_01_standard.jpg"
        val shoeList = mutableListOf<Shoe>(
            Shoe(1, "Zapato 1", 99.99, url),
            Shoe(2, "Zapato 2", 79.99, url),
            Shoe(3, "Zapato 3", 149.99, url),
            Shoe(4, "Zapato 4", 99.99, url),
            Shoe(5, "Zapato 5", 79.99, url),
            Shoe(6, "Zapato 6", 149.99, url),
            Shoe(7, "Zapato 7", 99.99, url),
            Shoe(8, "Zapato 8", 79.99, url),
            Shoe(9, "Zapato 9", 149.99, url),
            Shoe(10, "Zapato 10", 99.99, url)
        )
        return shoeList
    }
}