package com.jordilucas.pontosturisticoscaninde.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jordilucas.pontosturisticoscaninde.R
import com.jordilucas.pontosturisticoscaninde.dto.Atracao
import com.jordilucas.pontosturisticoscaninde.extensions.loadUrl
import kotlinx.android.synthetic.main.item_list_atracoes.view.*
import kotlinx.android.synthetic.main.progress.view.*

class AtracaoListAdapter(private val atracaoList : List<Atracao>, private val context : Context )
        : RecyclerView.Adapter<AtracaoListAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_atracoes, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = atracaoList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView
        val atracao = atracaoList[position]

        with(view){
            txt_nome_atracao.text = atracao.nome
            txt_hrs_func.text = atracao.horario_func
            imgView.loadUrl(atracao.foto, view.progress)
        }
    }

}