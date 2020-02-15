package com.jordilucas.pontosturisticoscaninde.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.QuerySnapshot
import com.jordilucas.pontosturisticoscaninde.R
import kotlinx.android.synthetic.main.item_list_atracoes.view.*

class AtracaoListAdapter(
    private val atracoes: List<String>
)
        : RecyclerView.Adapter<AtracaoListAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_atracoes,
            parent, false)
        return ViewHolder(view)
    }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView
        val atracao = atracoes[position]
        with(view){
            txt_nome_atracao.text = atracao
        }
    }
    override fun getItemCount() = atracoes.size
}