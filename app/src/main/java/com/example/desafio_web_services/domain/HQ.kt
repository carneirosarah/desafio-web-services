package com.example.desafio_web_services.domain

import java.io.Serializable
import kotlin.collections.ArrayList

data class Res (val data: Data)
data class Data (val offset: Int, var results: ArrayList<HQ>)
data class Date (var type: String, var date: String)
data class Price(var type: String, var price: Double)
data class Thumbnail(var path: String, var extension: String)
data class HQ (val id: Int, var description: String,  var thumbnail: Thumbnail, var dates: ArrayList<Date>, var prices: ArrayList<Price>): Serializable