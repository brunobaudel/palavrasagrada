package com.mobsky.navigate

abstract class Navigate

sealed class RootGraph : Navigate() {
    class Root(val rote: String = "rootGraph") : Navigate()
}

sealed class HomeGraph : Navigate() {
    class Root(val rote: String = "homeGraph") : Navigate()
    class Home(val rote: String = "home") : Navigate()

}

fun String.getRouteWithParametersValue(value: String) = "$this\\$value"