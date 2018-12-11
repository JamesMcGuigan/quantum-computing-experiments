package com.jamesmcguigan.factorization

import org.scalatest.{FreeSpec, Matchers}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map


object BruteForceSpec {
  // Source: https://www.rsok.com/~jrm/first100primes.html
  val knownPrimes : Array[Int] = Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541)

  val knownFactors: mutable.Map[Set[Int],Int] = {
    val factors : mutable.Map[Set[Int],Int] = mutable.Map()
    for( i <- knownPrimes ) for( j <- knownPrimes ) {
      val product  = i * j
      val key      = Set(1, i, j, product)
      factors(key) = product
    }
    factors
  }
}

class BruteForceSpec extends FreeSpec with Matchers {

  "factors" - {
    for ((factors, number) <- BruteForceSpec.knownFactors ) {
      s"match knownFactors: $number = $factors" in {
        val answer = BruteForce.factors(number)
        answer shouldEqual factors
      }
    }
  }

  "primeFactors" - {
    for ((factors, number) <- BruteForceSpec.knownFactors ) {
      val primeFactors = factors - (1, number)
      s"match knownFactors: $number = $primeFactors" in {
        val answer = BruteForce.primeFactors(number)
        answer shouldEqual primeFactors
      }
    }
  }

  "isPrime" - {
    for (n <- 1 to BruteForceSpec.knownPrimes.max ) {
      if( BruteForceSpec.knownPrimes contains n ) {
        s"match knownPrimes: $n" in {
          val isPrime = BruteForce.isPrime(n)
          isPrime shouldEqual true
        }
      } else {
        s"not match knownPrimes: $n" in {
          val isPrime = BruteForce.isPrime(n)
          isPrime shouldEqual false
        }
      }
    }
  }

}
