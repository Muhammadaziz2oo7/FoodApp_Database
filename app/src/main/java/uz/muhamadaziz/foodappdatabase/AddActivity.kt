package uz.muhamadaziz.foodappdatabase

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.muhamadaziz.foodappdatabase.Content.list
import uz.muhamadaziz.foodappdatabase.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private lateinit var foodList: ArrayList<FoodData>
    private lateinit var myDataBase: MyDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myDataBase = MyDataBase(this)
        foodList = myDataBase.getAllFoodList() as ArrayList<FoodData>

        binding.add.setOnClickListener {

            val name: String =binding.name.text.toString()
            val kerakli: String = binding.need.text.toString()
            val tartib: String = binding.tartib.text.toString()
            val foodData = FoodData(name, kerakli, tartib)
            foodList.add(foodData)
            myDataBase.addFood(foodData)
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}