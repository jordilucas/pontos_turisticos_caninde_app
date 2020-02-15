package com.jordilucas.pontosturisticoscaninde.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.jordilucas.pontosturisticoscaninde.R
import com.jordilucas.pontosturisticoscaninde.dto.Atracao
import kotlinx.android.synthetic.main.fragment_atracao.*

class AtracaoFragments : Fragment() {

    private val db = FirebaseFirestore.getInstance()
    private val rf = db.collection("pontos_turisticos")

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
        atracao()
    }


    fun atracaoFirebase(){
        val query = rf.orderBy("Nome", Query.Direction.ASCENDING)
        val options =
            FirestoreRecyclerOptions.Builder<Atracao>()
                .setQuery(query, Atracao::class.java)
                .build()
    }

    fun atracao(){
        var t = ""
        val db = FirebaseFirestore.getInstance()
            .collection("pontos_turisticos")
            .get()
            .addOnSuccessListener { result ->
                /*val atracao =
                Log.d("ResultJson", "${result.documents.toList().toJson()}")
                result.documents.forEach{
                   t = it.data!!.toJson()
                    Log.d("JSON", "${t}")
                }*/

            }
        var atracoesList = arrayListOf<String>()
        /* db.collection("pontos_turisticos")
             .get()
             .addOnSuccessListener { result ->
                 for(document in result){
                     atracoesList.add(document.data)
                 }
                 recyclerView.adapter = AtracaoListAdapter(atracoesList)
                 progressBar.visibility = View.GONE
             }
             .addOnFailureListener { exception ->
                 Log.w("Firebase Error ", "Erro getting documents. ", exception)
             }*/

    }

    /*open fun onClick(atracao: Atracao){
        activity.startActivity<DescriptionActivity>("atracao" to atracao)
    }*/

}