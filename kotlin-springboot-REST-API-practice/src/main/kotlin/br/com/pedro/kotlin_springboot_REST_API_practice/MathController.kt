package br.com.pedro.kotlin_springboot_REST_API_practice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Math.pow
import br.com.pedro.kotlin_springboot_REST_API_practice.exceptions.*
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong(0)

    @GetMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) 
            throw UnsupportedMathOperationException("Please set a numeric value!")
        
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }
    
    @GetMapping(value = ["/subtract/{numberOne}/{numberTwo}"])
    fun subtract(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) 
            throw UnsupportedMathOperationException("Please set a numeric value!")
        
        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    @GetMapping(value = ["/multiply/{numberOne}/{numberTwo}"])
    fun multiply(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) 
            throw UnsupportedMathOperationException("Please set a numeric value!")
        
        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    @GetMapping(value = ["/divide/{numberOne}/{numberTwo}"])
    fun divide(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) 
            throw UnsupportedMathOperationException("Please set a numeric value!")
        
        val convertedNumberTwo = convertToDouble(numberTwo)
        
        if( convertedNumberTwo == 0.0)
            throw DivisionByZeroException("Division by zero not allowed, please set a non-zero value for the second number!")

        return convertToDouble(numberOne) / convertedNumberTwo
    }

    @GetMapping(value = ["/average/{numberOne}/{numberTwo}"])
    fun average(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) 
            throw UnsupportedMathOperationException("Please set a numeric value!")
        
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2.0
    }

    @GetMapping(value = ["/power/{numberOne}/{numberTwo}"])
    fun power(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) 
            throw UnsupportedMathOperationException("Please set a numeric value!")
        
        return pow(convertToDouble(numberOne), convertToDouble(numberTwo))
    }

    private fun convertToDouble(strNumber: String?): Double {

        if(strNumber.isNullOrBlank()) 
            return 0.0

        val number = strNumber.replace(",".toRegex(), ".")

        return if(isNumeric(number)) number.toDouble() else 0.0
     }

    private fun isNumeric(strNumber: String?): Boolean {

        if(strNumber.isNullOrBlank()) return false

        val number = strNumber.replace(",".toRegex(), ".")

        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}