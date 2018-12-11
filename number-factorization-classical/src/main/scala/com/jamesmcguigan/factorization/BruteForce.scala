package com.jamesmcguigan.factorization
import scala.collection.mutable.ListBuffer
import scala.math.{ceil,sqrt}

object BruteForce extends Factorization {

  override def factors(number: Int): Array[Int] = {
    val max: Int = sqrt(number.toDouble).toInt
    var factors: ListBuffer[Int] = ListBuffer()
    for( n <- 1 to max if n % 2 == 1 ) {
      if( number % n == 0 && factors.size <= 2 ) {
        factors += n
      }
    }
    return factors.toArray
  }

  override def primeFactors(number: Int): Array[Int] = {
    return factors(number).filter(isPrime)
  }

  override def isPrime(number: Int): Boolean = {
    if( number == 1     ) { return false; }
    if( number == 2     ) { return true;  }
    if( number % 2 == 0 ) { return false; }

    val max: Int = ceil(sqrt(number.toDouble)).toInt  // ceil() required to match number 2
    var factors: ListBuffer[Int] = ListBuffer()
    for( n <- 1 to max if factors.size <= 2 ) {
      if( number % n == 0 ) {
        factors += n
      }
    }
    return factors.size == 1
  }

}
