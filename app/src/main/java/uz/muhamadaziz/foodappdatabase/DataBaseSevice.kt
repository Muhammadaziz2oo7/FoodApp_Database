package uz.muhamadaziz.foodappdatabase

interface DataBaseSevice {

    fun addFood(foodData: FoodData)

    fun deleteFood(foodData: FoodData)

    fun getAllFoodList(): List<FoodData>
}