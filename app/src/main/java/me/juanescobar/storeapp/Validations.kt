package me.juanescobar.storeapp

import android.util.Patterns


fun validateEmail(email : String) : Pair<Boolean, String>{
    return when{
        email.isEmpty() -> Pair(false, "El correo es requerido")
        !email.endsWith("@unab.edu.co") -> Pair(false, "Solo correos institucionales")
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> Pair(false, "Solo correos validos")
    }
}

fun validatePassword(password : String) : Pair<Boolean, String>{
    return when{
        password.isEmpty() -> Pair(false, "La contraseña es requerida")
        password.length < 8 -> Pair(false, "La contraseña debe tener mininimo 8 caracteres")
        else -> {
            Pair(true, "")
        }
    }
}