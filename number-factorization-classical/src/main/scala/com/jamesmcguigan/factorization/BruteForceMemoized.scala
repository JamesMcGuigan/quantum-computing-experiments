package com.jamesmcguigan.factorization

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.math.{ceil, sqrt}
//import scalacache._
//import scalacache.memcached._
//import scalacache.memoization._
//import scalacache.serialization.binary._
import scalaz.Memo


object BruteForceMemoized extends Factorization {

  val _factorsCache : mutable.Map[Int, Set[Int]] = mutable.Map()
  override def factors(number: Int): Set[Int] = _factorsCache.getOrElseUpdate(number, {
    val max: Int = number / 2
    var factors: ListBuffer[Int] = ListBuffer(number)
    for( n <- 1 to max if !factors.contains(n) && number % n == 0 ) {
      factors += n
      factors ++= _factorsCache.getOrElse(n, Set())
    }
    return factors.toSet
  })


  def primeFactors(number: Int): Set[Int] = {
    BruteForce.primeFactors(number)
  }


  val _isPrimeCache : mutable.Map[Int, Boolean] = mutable.Map()
  def isPrime(number: Int): Boolean = _isPrimeCache.getOrElseUpdate(number, {
    BruteForce.isPrime(number)
  })
}
