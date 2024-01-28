package com.example.mywishlist.data

class FakeRepository {
    fun getItems():List<Item>{
        return listOf(
            Item(
                title = "Xbox Game Controller",
                website = "https://www.xbox.com/en-IN/accessories/controllers/xbox-wireless-controller",
                img = "https://m.media-amazon.com/images/I/51-VUKOiYUL._SX679_.jpg",
                priority = Priority.High
            ),
            Item(
                title = "Xbox Game Controller",
                website = "https://www.xbox.com/en-IN/accessories/controllers/xbox-wireless-controller",
                img = "https://assets.xboxservices.com/assets/e5/4c/e54c5416-9bca-412b-beea-5133e61491ac.jpg?n=Xbox-Wireless-Controller_Feature-Image-Priority-0_1040x867",
                priority = Priority.High
            )

        )
    }
}