package br.com.pedro.kotlin_springboot_REST_API_practice.utils

object NumericUtils {

    fun convertToDouble(strNumber: String?): Double {

        if(strNumber.isNullOrBlank()) 
            return 0.0

        val number = strNumber.replace(",".toRegex(), ".")

        return if(isNumeric(number)) number.toDouble() else 0.0
     }

    fun isNumeric(strNumber: String?): Boolean {

        if(strNumber.isNullOrBlank()) return false

        val number = strNumber.replace(",".toRegex(), ".")

        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }

}