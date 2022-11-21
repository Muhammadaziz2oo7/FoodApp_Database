package uz.muhamadaziz.foodappdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.muhamadaziz.foodappdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.add.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
        binding.menyu.setOnClickListener {
            startActivity(Intent(this,MenuActivity::class.java))
        }

    }
}