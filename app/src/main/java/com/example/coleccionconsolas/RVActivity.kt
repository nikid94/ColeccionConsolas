package com.example.coleccionconsolas

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coleccionconsolas.clases.Consola
import com.example.coleccionconsolas.clases.ConsolaAdapter
import com.example.coleccionconsolas.databinding.ActivityRvBinding
import com.google.android.material.snackbar.Snackbar

class RVActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var consolasList = mutableListOf<Consola>(
            Consola("Super Nintendo", "La Super Nintendo Entertainment System, (también conocida como SNES o Super Nintendo) es una videoconsola de 16 bits que fue lanzada en 1990 en Japón, en 1991 en Norteamérica, en 1992 en Europa y Oceanía, y en 1993 en Sudamérica.", true),
            Consola("Play Station", "La PlayStation (PS1) desarrollada por Sony en la década de los 90 que utiliza el CD-ROM como soporte de almacenamiento para sus juegos siendo, hasta esa fecha, la única exitosa en el uso del CD-ROM en consolas.", true),
            Consola("Xbox", "La Xbox es una consola de videojuegos desarrollada por Microsoft en 2005.", false),
            Consola("Switch", "La Nintendo Switch es una consola de videojuegos desarrollada y marketed por Nintendo para la consola Nintendo Switch, con su sistema operativo y juegos en la consola", false)
        )

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = ConsolaAdapter(this, consolasList)

        val callback = object: OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {

                val builder = AlertDialog.Builder(this@RVActivity)
                builder.setTitle(R.string.retrocesoPulsado)
                    .setMessage(R.string.alertaCerrarSesion)
                    .setPositiveButton(R.string.si, {
                        _, _-> startActivity(Intent(this@RVActivity, LoginActivity::class.java))
                    })
                    .setNegativeButton(R.string.no, { dialog, _ ->
                        Snackbar.make(binding.root, getString(R.string.cancelarCerrarSesion), Snackbar.LENGTH_LONG).show()
                    })
                    .show()
            }
        }

        onBackPressedDispatcher.addCallback(callback)


    }
}