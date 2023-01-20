package com.meruvia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.meruvia.databinding.ActivityQrBinding

class QrActivity : AppCompatActivity() {

    private lateinit var binding : ActivityQrBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScan.setOnClickListener { initScanner() }
    }

    private fun initScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("Enfoque el código que desea escanear")
        integrator.setTorchEnabled(false)//flash
        integrator.setBeepEnabled(true)//pitido
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if(result != null){
            if(result.contents == null){
                //Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
                binding.tvResultado.text = "Cancelado"
            }else{
                //Toast.makeText(this, "El valor escaneado es: ${result.contents}", Toast.LENGTH_SHORT).show()
                binding.tvResultado.text = "El valor escaneado es: ${result.contents}"
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}