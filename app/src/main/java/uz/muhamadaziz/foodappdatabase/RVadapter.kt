package uz.muhamadaziz.foodappdatabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.muhamadaziz.foodappdatabase.databinding.ItemFoodBinding

class RVadapter(var onItemClick: OnItemClick, var foodList: ArrayList<FoodData>): RecyclerView.Adapter<RVadapter.VH>() {

    inner class VH(private val binding: ItemFoodBinding): RecyclerView.ViewHolder(binding.root){

        fun onBind(foodData: FoodData, position: Int){
            binding.foodName.text =foodData.name
            binding.root.setOnLongClickListener {
                onItemClick.onClick(foodData, position)
                true
            }
            binding.root.setOnClickListener {
                onItemClick.onItemClick(foodData, position)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent ,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(foodList[position], position)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    interface OnItemClick {

        fun onClick(foodData: FoodData, position: Int)
        fun onItemClick(foodData: FoodData, position: Int)
    }
}