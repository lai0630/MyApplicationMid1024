package im.ntub.myapplication0313

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

/**
 * 組員:11056010李益誠
 * 11056024賴顗翔
 * */

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    // 接收传递的数据
    private var selectedPizza: String? = null
    private var selectedDrink: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cnbNugget = findViewById<CheckBox>(R.id.cnbNugget)
        val cnbFries = findViewById<CheckBox>(R.id.cnbFries)

        val btnCal = findViewById<Button>(R.id.btnCal)

        val rdoPizza1 = findViewById<RadioButton>(R.id.rdoPizza1)
        val rdoPizza2 = findViewById<RadioButton>(R.id.rdoPizza2)
        val rdoPizza3 = findViewById<RadioButton>(R.id.rdoPizza3)
        val rdoCola = findViewById<RadioButton>(R.id.rdoCola)
        val rdoBlacktea = findViewById<RadioButton>(R.id.rdoBlacktea)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)
        val imgFries = findViewById<ImageView>(R.id.imgPizza2)
        imgFries.imageAlpha
        //計算
        var count = 0


        //返回
        findViewById<Button>(R.id.btnCal).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("確認訂單")
                .setMessage("是否確定下單？")
                .setNeutralButton("取消") { dialog, which ->
                    // 中性按钮点击事件
                }
                .setPositiveButton("確定") { dialog, which ->
                    // 获取选中的 RadioGroup 数据
                    val selectedPizzaId = radioGroup.checkedRadioButtonId
                    val selectedDrinkId = radioGroup2.checkedRadioButtonId


                    // 根据选中的 ID 获取对应的文本信息
                    val selectedPizza = findViewById<RadioButton>(selectedPizzaId)?.text?.toString()
                    val selectedDrink = findViewById<RadioButton>(selectedDrinkId)?.text?.toString()

                    val isFriesChecked = cnbFries.isChecked
                    val isNuggetChecked = cnbNugget.isChecked

                    // 创建 Intent 并传递数据到目标 Activity
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("pizza", selectedPizza)
                    intent.putExtra("drink", selectedDrink)
                    intent.putExtra("count",count)
                    intent.putExtra("friesChecked", isFriesChecked)
                    intent.putExtra("nuggetChecked", isNuggetChecked)
                    var count = 0
                    when (selectedPizzaId) {
                        R.id.rdoPizza1 -> count += 90
                        R.id.rdoPizza2 -> count += 100
                        R.id.rdoPizza3 -> count += 120
                    }
                    when (selectedDrinkId) {
                        R.id.rdoCola -> count += 10
                        R.id.rdoBlacktea -> count += 20
                    }
                    if (isFriesChecked) {
                        count += 30
                    }
                    if (isNuggetChecked) {
                        count += 40
                    }
                    intent.putExtra("count", count) // 将正确计算的 count 传递给 SecondActivity

                    startActivity(intent) // 启动目标 Activity
                }
                .show()
        }
        }


    //就是回到前一頁 如果用intent就會讓第一頁再蓋到第二頁上面 變成1->2->1

        /*
        btnClick.setOnClickListener {  //當按鈕被按下後
            if(cnbTea.isChecked){//如果你的這個有打勾
                txtResult.text = "V"//這個顯示格就會跑出V
            }else{
                txtResult.text = "X"
            }
            val number: Int = txtNumber.text.toString().toInt()//先變字串在變整數
        }
        cnbTea.setOnCheckedChangeListener { buttonView, isChecked ->//看勾選狀態是否有改變 就可以不用按按鈕
            if(isChecked){//如果被勾起來的話
                txtResult.text = "CheckedChange->V"
            }else{
                txtResult.text = "CheckedChange->X"
            }
        }
        */
    }
