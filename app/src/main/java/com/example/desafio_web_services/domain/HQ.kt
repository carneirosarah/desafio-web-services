package com.example.desafio_web_services.domain

import java.io.Serializable

class HQ (val id: Int, var description: String,  var thumbnail: String, var dates: ArrayList<String>, var prices: ArrayList<String>): Serializable