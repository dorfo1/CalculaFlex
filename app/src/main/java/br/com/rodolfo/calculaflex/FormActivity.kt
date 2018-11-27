package br.com.rodolfo.calculaflex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        form_btn_calcular.setOnClickListener{
            if(form_et_preco_gas.length()==0 || form_et_preco_etanol.length()==0 || form_et_kmL_alcool.length()==0 || form_et_kmL_gasolina.length()==0){
                Toast.makeText(this,"Preencha todos os campos para avançar",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,ResultadoActivity::class.java)
                intent.putExtra("PRECO_GAS",form_et_preco_gas.text.toString().toDouble())
                intent.putExtra("PRECO_ETANOL",form_et_preco_etanol.text.toString().toDouble())
                intent.putExtra("PRECO_KM_GAS",form_et_kmL_gasolina.text.toString().toDouble())
                intent.putExtra("PRECO_KM_ALCOOL",form_et_kmL_alcool.text.toString().toDouble())
                startActivity(intent)
            }
        }
    }
}
