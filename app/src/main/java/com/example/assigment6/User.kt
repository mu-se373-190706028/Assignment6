package com.example.assigment6

class User {
    private var id = 0
    private var name: String? = null
    private  var email:String? = null
    private  var gender:String? = null


    constructor(id: Int, name: String, email: String, gender: String) {
        this.id = id
        this.email = email
        this.gender = gender
        this.name = name
    }

    fun getId(): Int {
        return id
    }
    fun setId(id: Int) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }
    fun setName(name: String?) {
        this.name = name
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }


    fun getGender(): String? {
        return gender
    }

    fun setGender(gender: String) {
        this.gender = gender
    }

}