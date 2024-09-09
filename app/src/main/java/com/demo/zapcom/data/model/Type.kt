package com.demo.zapcom.data.model

//enum class Type {
//    horizontalFreeScroll,
//    splitBanner,
//    banner
//
//}
enum class Type(private val type: String) {
    HORIZONTAL_FREE_SCROLL("horizontalFreeScroll"),
    SPLIT_BANNER("splitBanner"),
    BANNER("banner");

    fun getType(): String {
        return type
    }
}
