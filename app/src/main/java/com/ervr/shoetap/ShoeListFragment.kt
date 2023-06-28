package com.ervr.shoetap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoeListFragment : Fragment(), ShoeAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shoe_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shoeList = returnShoeList()
        val adapter = ShoeAdapter(shoeList)
        adapter.listener = this
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onItemClick(shoe: Shoe) {
        val productFragment = ProductFragment().apply {
            arguments = Bundle().apply {
                putParcelable("shoe", shoe)
            }
        }

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, productFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun returnShoeList(): List<Shoe> {
        val shoeList = listOf(
            Shoe("Zapato 1", "https://example.com/zapato1.jpg", 99.99),
            Shoe("Zapato 2", "https://example.com/zapato2.jpg", 79.99),
            Shoe("Zapato 3", "https://example.com/zapato3.jpg", 149.99),
            Shoe("Zapato 4", "https://example.com/zapato1.jpg", 99.99),
            Shoe("Zapato 5", "https://example.com/zapato2.jpg", 79.99),
            Shoe("Zapato 6", "https://example.com/zapato3.jpg", 149.99),
            Shoe("Zapato 7", "https://example.com/zapato1.jpg", 99.99),
            Shoe("Zapato 8", "https://example.com/zapato2.jpg", 79.99),
            Shoe("Zapato 9", "https://example.com/zapato3.jpg", 149.99),
            Shoe("Zapato 10", "https://example.com/zapato1.jpg", 99.99)
        )
        return shoeList
    }
}
