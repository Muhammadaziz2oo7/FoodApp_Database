package uz.muhamadaziz.foodappdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.muhamadaziz.foodappdatabase.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val food = intent.getSerializableExtra("food") as FoodData

        binding.name.text = food.name
        binding.kerakli.text = food.kerakli_max
        binding.tartib.text = food.tay_tartib

    }
}