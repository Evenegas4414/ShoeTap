package com.ervr.shoetap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoeListFragment : Fragment(), ShoeAdapter.OnItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shoe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shoeList = returnShoeList()
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = ShoeAdapter(shoeList, this)
    }

    private fun returnShoeList(): List<Shoe> {
        var url =
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/89afa6a48d7d4732b8daaead00ed1b45_9366/Start_Your_Run_Shoes_Black_GY9234_01_standard.jpg"
        val shoeList = mutableListOf<Shoe>(
            Shoe(1, "ZAPATILLAS NMD_V3", 120.999, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/2f9d30d67052438081f4ae96017d4760_9366/Zapatillas_NMD_V3_Verde_HQ3970_01_standard.jpg"),
            Shoe(2, "ZAPATILLAS FORUM LOW", 57.999, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/be267c0d2b55486f98beacfd01049bfc_9366/Zapatillas_Forum_Low_Blanco_FY7978_01_standard.jpg"),
            Shoe(3, "ZAPATILLAS TENSAUR", 23.999, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/cde75dc9fb194796bcedae8d003f303c_9366/Zapatillas_Tensaur_Tira_Ajustable_de_Cierre_por_Contacto_Negro_GW6455_01_standard.jpg"),
            Shoe(4, "ZAPATILLAS MONOFIT TRAINER", 39.999, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/96d86226e52546d6ae4aaf8000db58d2_9366/Zapatillas_MONOFIT_Trainer_Lifestyle_Calce_Facil_Azul_HP7767_01_standard.jpg"),
            Shoe(5, "ZAPATILLAS MULTIX", 59.999, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/637989250df04e718330ae92008907ef_9366/Zapatillas_Multix_Rosado_GX4811_01_standard.jpg"),
            Shoe(6, "ZAPATILLAS ADVANTAGE COURT", 29.999, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/509f8e23de71480997aeae9000829152_9366/Zapatillas_Advantage_adidas_Court_Blanco_GY6996_01_standard.jpg"),
            Shoe(7, "ZAPATILLAS SUPERSTAR (UNISEX)", 69.999, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a5222393204c4190b5a4ab0000b325cc_9366/Zapatillas_Superstar_UNISEX_Negro_EF5398_01_standard.jpg"),
            Shoe(8, "ZAPATILLAS ADIDAS DNA X LEGO", 74.999, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/0542bad5482e44209e25af3401480444_9366/Zapatillas_adidas_DNA_x_LEGOr_Tira_Ajustable_Negro_HQ1311_01_standard.jpg"),
            Shoe(9, "ZAPATILLAS X9000L4", 71.999, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/91d455be348b40adbdcbae2a0088d938_9366/Zapatillas_X9000L4_Negro_HR1728_01_standard.jpg"),
            Shoe(10, "ZAPATILLAS WEB BOOST", 149.999, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/e339c8659094457b86ffafc1007b5e77_9366/Zapatillas_Web_Boost_Negro_IF5282_01_standard.jpg")
        )
        return shoeList
    }

    override fun onItemClick(shoe: Shoe) {
        val bundle = Bundle().apply { putParcelable("shoe", shoe) }
        findNavController().navigate(R.id.productFragment, bundle)
    }
}
