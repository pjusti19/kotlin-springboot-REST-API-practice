package br.com.pedro.kotlin_springboot_REST_API_practice.utils

import br.com.pedro.kotlin_springboot_REST_API_practice.exceptions.DivisionByZeroException
import kotlin.math.pow
import kotlin.math.sqrt

object MathOperations {

    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo

    fun subtract(numberOne: Double, numberTwo: Double) = numberOne - numberTwo

    fun multiply(numberOne: Double, numberTwo: Double) = numberOne * numberTwo

    fun divide(numberOne: Double, numberTwo: Double): Double {
        if (numberTwo == 0.0)
            throw DivisionByZeroException("Division by zero not allowed, please set a non-zero value for the second number!")
        return numberOne / numberTwo
    }

    fun mean(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo) / 2.0

    fun power(numberOne: Double, numberTwo: Double) = numberOne.pow(numberTwo)

    fun squareRoot(number: Double) = sqrt(number)
}