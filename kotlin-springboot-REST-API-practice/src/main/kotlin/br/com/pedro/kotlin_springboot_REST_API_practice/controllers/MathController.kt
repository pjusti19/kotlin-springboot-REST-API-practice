package br.com.pedro.kotlin_springboot_REST_API_practice.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import br.com.pedro.kotlin_springboot_REST_API_practice.exceptions.UnsupportedMathOperationException
import br.com.pedro.kotlin_springboot_REST_API_practice.utils.MathOperations
import br.com.pedro.kotlin_springboot_REST_API_practice.utils.NumericUtils

@RestController
class MathController {

    @GetMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return MathOperations.sum(NumericUtils.convertToDouble(numberOne), NumericUtils.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/subtract/{numberOne}/{numberTwo}"])
    fun subtract(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return MathOperations.subtract(NumericUtils.convertToDouble(numberOne), NumericUtils.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/multiply/{numberOne}/{numberTwo}"])
    fun multiply(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return MathOperations.multiply(NumericUtils.convertToDouble(numberOne), NumericUtils.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/divide/{numberOne}/{numberTwo}"])
    fun divide(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return MathOperations.divide(NumericUtils.convertToDouble(numberOne), NumericUtils.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return MathOperations.mean(NumericUtils.convertToDouble(numberOne), NumericUtils.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/power/{numberOne}/{numberTwo}"])
    fun power(@PathVariable(value = "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return MathOperations.power(NumericUtils.convertToDouble(numberOne), NumericUtils.convertToDouble(numberTwo))
    }

    @GetMapping(value = ["/squareroot/{number}"])
    fun squareRoot(@PathVariable(value = "number") number: String?): Double {

        if (!NumericUtils.isNumeric(number))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return MathOperations.squareRoot(NumericUtils.convertToDouble(number))
    }

}