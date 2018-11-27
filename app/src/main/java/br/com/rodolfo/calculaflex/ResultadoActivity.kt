package br.com.rodolfo.calculaflex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        if(intent.extras==null){
            Toast.makeText(this,"Não foi possivel fazer o calculo",Toast.LENGTH_SHORT).show();
        }else{
            calcularValor();
        }
    }

    private fun calcularValor() {
        val gasPrice = intent.extras.getDouble("PRECO_GAS", 0.0)
        val ethanolPrice = intent.extras.getDouble("PRECO_ETANOL", 0.0)
        val gasAverage = intent.extras.getDouble("PRECO_KM_GAS", 0.0)
        val ethanolAverage = intent.extras.getDouble("PRECO_KM_ALCOOL", 0.0)
        val performanceOfMyCar = ethanolAverage / gasAverage
        val priceOfFuelIndice = ethanolPrice / gasPrice
        if (priceOfFuelIndice <= performanceOfMyCar) {
            resultado_sugestao_valor.text = getString(R.string.etanol)
        } else {
            resultado_sugestao_valor.text = getString(R.string.gasoline)
        }
        resultado_etanol_valor.text = (ethanolPrice / ethanolAverage).toString()
        resultado_gasolina_valor.text = (ethanolPrice / ethanolAverage).toString()
    }
}
