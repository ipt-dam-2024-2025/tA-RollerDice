package pt.ipt.dam.roolerdice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    lateinit var imagem: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // fazer referência ao Botão da app
        var bt: Button = findViewById(R.id.btRollDice)
        bt.setOnClickListener {
            // gerar uma msg de aviso
            Toast.makeText(this,"Foi pressionado o botão",Toast.LENGTH_LONG).show()
            // testar com o objeto: snackbar

            // gerar um valor aleatório para mostrar o dado correspondente
            rodaDados()
        }
    }

    /**
     * função que irá gerar um novo valor do dado
     */
    private fun rodaDados() {
        // Algoritmo:
        // 1. gerar um número aleatório entre [1;6]
        // 2. associar a imagem respetiva ao ImageView
        // 3. escrever o valor do nº aleatório no ecrã

        // 1.
        var numeroAleatorio = Random().nextInt(6) + 1 // valores entre 1 e 6

        // 2.
        var imagemParaImageView = when (numeroAleatorio) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        imagem = findViewById(R.id.imageViewDado)
        imagem.setImageResource(imagemParaImageView)

        // 3.
        findViewById<TextView>(R.id.textViewValorDado).text = numeroAleatorio.toString()

    }


}
