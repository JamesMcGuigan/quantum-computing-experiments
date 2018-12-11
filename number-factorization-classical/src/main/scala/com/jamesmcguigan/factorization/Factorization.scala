package com.jamesmcguigan.factorization

trait Factorization {
  def factors(number: Int): Array[Int]
  def primeFactors(number: Int): Array[Int]
  def isPrime(number: Int): Boolean
}
