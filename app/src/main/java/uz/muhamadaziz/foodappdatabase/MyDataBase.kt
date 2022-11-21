package uz.muhamadaziz.foodappdatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import uz.muhamadaziz.foodappdatabase.Content.DB_NAME
import uz.muhamadaziz.foodappdatabase.Content.DB_VERSION
import uz.muhamadaziz.foodappdatabase.Content.ID
import uz.muhamadaziz.foodappdatabase.Content.KERAKLI
import uz.muhamadaziz.foodappdatabase.Content.NAME
import uz.muhamadaziz.foodappdatabase.Content.TABLE_NAME
import uz.muhamadaziz.foodappdatabase.Content.TARTIB

class MyDataBase(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION),
    DataBaseSevice {
    override fun onCreate(db: SQLiteDatabase?) {
        val query: String =
            "CREATE TABLE $TABLE_NAME($ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, $NAME TEXT NOT NULL, $KERAKLI TEXT NOT NULL, $TARTIB TEXT NOT NULL)"
        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS  $TABLE_NAME")
        onCreate(db)
    }

    override fun addFood(foodData: FoodData) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME, foodData.name)
        contentValues.put(KERAKLI, foodData.kerakli_max)
        contentValues.put(TARTIB, foodData.tay_tartib)
        database.insert(TABLE_NAME, null, contentValues)
        database.close()
    }

    override fun deleteFood(foodData: FoodData) {
        val database = this.writableDatabase
        database.delete(TABLE_NAME, "$ID = ?", arrayOf("${foodData.id}"))
        database.close()
    }

    override fun getAllFoodList(): List<FoodData> {

        val foodList = ArrayList<FoodData>()

        val query: String = "SELECT * FROM $TABLE_NAME"
        val dataBase = this.readableDatabase
        val cursor = dataBase.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val id: Int =cursor.getInt(0)
                val name: String =cursor.getString(1)
                val kerakli: String = cursor.getString(2)
                val tartib: String = cursor.getString(3)

                val food = FoodData(id, name, kerakli, tartib)
                foodList.add(food)
            }while (cursor.moveToNext())
        }
        return foodList

    }
}