package im.ntub.myapplication0313

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txtHeader = findViewById<TextView>(R.id.txtHeader)
        val txtStaple = findViewById<TextView>(R.id.txtStaple)
        val txtDrink = findViewById<TextView>(R.id.txtDrink)
        val txtSnack = findViewById<TextView>(R.id.txtSnack)
        val txtStapleName = findViewById<TextView>(R.id.txtStapleName)
        val txtDrinkName = findViewById<TextView>(R.id.txtDrinkName)
        val txtFriesName = findViewById<TextView>(R.id.txtFriesName)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val txtTot = findViewById<TextView>(R.id.txtTot)
        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val imageView = findViewById<ImageView>(R.id.imgPizza)
        imageView.imageAlpha

        // 获取从上一个页面传递过来的数据
        val selectedPizza = intent.getStringExtra("pizza")
        val selectedDrink = intent.getStringExtra("drink")
        val isFriesChecked = intent.getBooleanExtra("friesChecked", false)
        val isNuggetChecked = intent.getBooleanExtra("nuggetChecked", false)
        val count = intent.getIntExtra("count",0)
        // 将传递过来的数据显示在界面上
        txtStapleName.text = selectedPizza ?: ""
        txtDrinkName.text = selectedDrink ?: ""
        if (isFriesChecked and isNuggetChecked) {
            txtFriesName.text = "雞塊+薯條 70元"
        }else if(isNuggetChecked){
            txtFriesName.text = "雞塊 40元"
        }else if(isFriesChecked){
            txtFriesName.text = "薯條 30元"
        }
        txtTot.text = count.toString()

        // 设置按钮点击事件，返回到 MainActivity 并传递数据
        btnOrder.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {
                // 将数据放入 Intent 中传递回 MainActivity
                putExtra("selectedPizza", selectedPizza)
                putExtra("selectedDrink", selectedDrink)
                val checkbox1State = intent.getBooleanExtra("checkbox1", false)
                val checkbox2State = intent.getBooleanExtra("checkbox2", false)
                putExtra("count",count)

            }
            startActivity(intent)
        }

    }
}