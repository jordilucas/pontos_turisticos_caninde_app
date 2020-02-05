package com.jordilucas.pontosturisticoscaninde.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.jordilucas.pontosturisticoscaninde.DescriptionActivity
import com.jordilucas.pontosturisticoscaninde.R
import com.jordilucas.pontosturisticoscaninde.adapter.AtracaoListAdapter
import com.jordilucas.pontosturisticoscaninde.dto.Atracao
import com.jordilucas.pontosturisticoscaninde.service.RetrofitInitializer
import kotlinx.android.synthetic.main.fragment_atracao.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AtracaoFragments : Fragment() {

    protected var atracao = listOf<Atracao>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_atracao, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager =LinearLayoutManager(activity)
        recyclerView.itemAnimator =DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        taskAtracao()
    }

    fun taskAtracao(){
        val call = RetrofitInitializer.atracaoService().atracaoList()
        call.enqueue(object : Callback<List<Atracao>> {
            override fun onFailure(call: Call<List<Atracao>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG)
            }

            override fun onResponse(call: Call<List<Atracao>>, response: Response<List<Atracao>>) {
                val atracaoList = response.body()!!
                progressBar.visibility = View.GONE
                recyclerView.adapter = AtracaoListAdapter(atracaoList)
            }

        })
    }

    /*open fun onClick(atracao: Atracao){
        activity.startActivity<DescriptionActivity>("atracao" to atracao)
    }*/

}