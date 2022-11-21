package uz.muhamadaziz.foodappdatabase

import java.io.Serializable

class FoodData: Serializable {

    var id: Int? = null
    var name: String? = null
    var kerakli_max: String? = null
    var tay_tartib: String? = null

    constructor(id: Int?, name: String?, kerakli_max: String?, tay_tartib: String?) {
        this.id = id
        this.name = name
        this.kerakli_max = kerakli_max
        this.tay_tartib = tay_tartib
    }

    constructor(name: String?, kerakli_max: String?, tay_tartib: String?) {
        this.name = name
        this.kerakli_max = kerakli_max
        this.tay_tartib = tay_tartib
    }

    override fun toString(): String {
        return "FoodData(id=$id, name=$name, kerakli_max=$kerakli_max, tay_tartib=$tay_tartib)"
    }
}