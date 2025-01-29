package com.example.coleccionconsolas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.coleccionconsolas.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    //Creamos la variable binding para relacionar los elementos de la vista con el activity
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var usuarioVacio = true
        var contraseAVacia = true

        binding.tfUsuario.editText?.addTextChangedListener { text ->
            if (text.isNullOrEmpty()) {
                binding.tfUsuario.error = "Este campo no puede estar vacío"
                usuarioVacio = true
            } else {
                binding.tfUsuario.error = null
                usuarioVacio = false
            }
        }

        binding.tfContraseA.editText?.addTextChangedListener { text ->
            if (text.isNullOrEmpty()) {
                binding.tfContraseA.error = "Este campo no puede estar vacío"
                contraseAVacia = true
            } else {
                binding.tfContraseA.error = null
                contraseAVacia = false
            }
        }

        binding.btnLoguear.setOnClickListener {
            if(usuarioVacio){
                Snackbar.make(it, this.getString(R.string.usuVacio), Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.cerrar){}
                    .setAnchorView(binding.tfUsuario)
                    .show()
            }else if(contraseAVacia){
                Snackbar.make(it, this.getString(R.string.contraVacia), Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.cerrar){}
                    .setAnchorView(binding.tfContraseA)
                    .show()
            }else {
                Snackbar.make(it, this.getString(R.string.loginCorrecto), Snackbar.LENGTH_LONG)
                    .show()
                startActivity(Intent(this, RVActivity::class.java))
            }
        }

        fun btnPulsado(button:Button){
            button.setOnClickListener {
                Snackbar.make(it, this.getString(R.string.botonPulsado) +" "+button.text ,
                    Snackbar.LENGTH_LONG)
                    .show()
            }
        }

        binding.btnRegistrar.setOnClickListener {
            startActivity(Intent(this, ContactoActivity::class.java))
        }

        //btnPulsado(binding.btnRegistrar)
        btnPulsado(binding.btnContraseA)
        btnPulsado(binding.btnFacebook)
        btnPulsado(binding.btnGoogle)


    }
}