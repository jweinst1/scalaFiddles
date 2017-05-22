//noun phrase generator example
//gnerates variations of noun phrases with a spcific list of subjects
//representing abstract grammar with function calls

import scala.util.Random

object main {
  def main():Unit = {
    for(_ <- 1 to 100) println(NounPhrase())
  }
}

//type alias for recursive calls and building sentences
type Sgen = ()=>String

object sample {
  //gets random element from array
  def arr[T](items:Array[T]):T = {
    items(Random.nextInt(items.length))
  }
  //samples callable sentence component and calls it
  def choice(items:Sgen*):String = items(Random.nextInt(items.length))()
}

//lowest level word bank
object words {
  //final nouns, will not serve as adjunct nouns
  val fnouns:Array[String] = Array("blueberry", "ball", "pear", "plane", "boatplane", "computer", "pencil", "pen")
  //nouns that represent activities
  val actnouns:Array[String] = Array("skating", "walking", "running", "batting", "bowling", "partying")
  val dets:Array[String] = Array("the", "a", "this", "that")
  val conjs:Array[String] = Array("and", "or", "nor")
}

object NounPhrase {
  //top level call
  def apply():String = {
    sample.choice(DN, nouns)
  }
  
  //variations in root of noun phrase
  //D = det P = premod N = noun O = postmod
  def DPNO():String = sample.choice()
  def DPN():String = sample.choice()
  def DN():String = s"${dets()} ${N()}"
  def NO():String = sample.choice()
  def PNO():String = sample.choice()
  def DNO():String = sample.choice()
  def PN():String = sample.choice()
  
  //dets and fnouns are simply sampled
  def dets():String = sample.arr(words.dets)
  def fnouns():String = sample.arr(words.fnouns)
  def actnouns():String = sample.arr(words.actnouns)
  def conjs():String = sample.arr(words.conjs)
  //picks between noun and coordinated nouns
  def nouns():String = sample.choice(N, NcN)
  
  //can continue
  def _N():String = sample.choice(fnouns, actnouns, _cN)
  //termnating
  def N():String = sample.choice(fnouns, actnouns)
  def NcN():String = s"${N()} ${_N()}"
  
  //continuing mechanism
  def _cN():String = sample.choice(cN, _n)
  def cN():String = s"${conjs()} ${N()}"
  def _n():String = ""
}



main.main()
