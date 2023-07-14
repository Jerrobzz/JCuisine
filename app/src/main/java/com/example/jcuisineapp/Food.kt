package com.example.jcuisineapp

class Food {
    var FoodImage:String = ""
    var imageId:String = ""
    var chefName:String = ""
    var chefId:String = ""

    constructor(FoodImage: String, imageId: String, chefName: String, chefId: String) {
        this.FoodImage = FoodImage
        this.imageId = imageId
        this.chefName = chefName
        this.chefId = chefId
    }
    constructor()
}