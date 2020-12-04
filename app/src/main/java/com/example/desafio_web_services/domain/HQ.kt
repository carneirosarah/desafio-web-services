package com.example.desafio_web_services.domain

import java.io.Serializable
import kotlin.collections.ArrayList

data class Res (val data: Data): Serializable
data class Data (val offset: Int, var results: ArrayList<HQ>): Serializable
data class Date (var type: String, var date: String): Serializable
data class Price(var type: String, var price: Double): Serializable
data class Thumbnail(var path: String, var extension: String): Serializable
data class HQ (val id: Int, var description: String,  var thumbnail: Thumbnail, var dates: ArrayList<Date>, var prices: ArrayList<Price>): Serializable