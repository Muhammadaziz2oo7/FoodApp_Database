package uz.muhamadaziz.foodappdatabase

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import uz.muhamadaziz.foodappdatabase.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var myDataBase: MyDataBase
    private lateinit var foodList: ArrayList<FoodData>
    private lateinit var adapter: RVadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDataBase = MyDataBase(this)

        foodList = myDataBase.getAllFoodList() as ArrayList<FoodData>
        adapter = RVadapter(object : RVadapter.OnItemClick {
            override fun onClick(foodData: FoodData, position: Int) {

                val alertDialog = AlertDialog.Builder(this@MenuActivity)

                alertDialog.setMessage("Rostdan ham o'chirmoqchimisiz?")
                val create = alertDialog.create()
                alertDialog.setPositiveButton("Ha") { _, _ ->
                    myDataBase.deleteFood(foodData)
                    foodList.remove(foodData)
                    adapter.notifyItemChanged(foodList.size)
                    adapter.notifyItemRemoved(foodList.size)
                    adapter.notifyItemRangeRemoved(position, foodList.size)
                }
                alertDialog.setNegativeButton("Yo'q") { _, _ ->
                    create.dismiss()
                }
                alertDialog.show()
            }

            override fun onItemClick(foodData: FoodData, position: Int) {
                val intent = Intent(this@MenuActivity, InfoActivity::class.java)
                intent.putExtra("food", foodData)
                startActivity(intent)
            }
        }, foodList)
        binding.recyclerView.adapter = adapter
    }
}