package com.jordilucas.pontosturisticoscaninde

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jordilucas.pontosturisticoscaninde.fragments.AtracaoFragments

class PontosTuristicosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pontos_turisticos)

        trocaFragmento(AtracaoFragments())

    }

    private fun trocaFragmento( fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations( android.R.anim.fade_in, android.R.anim.fade_out )
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }

}
