//scala collection comprehension examples
//tries to replicate python-like for comprehensions

object main {
  def main():Unit = {
    println(comp.trans(Array(1, 2, 3)).mkString(" "))
    println(comp.cond(Array(1, 2, 3, 5, 6, 6, 6)).mkString(" "))
  }
}

object comp {
  def trans(arr:Array[Int]):Array[(Int, Int)] = {
    for(num <- arr) yield (num, num+2)
  }
  
  def cond(arr:Array[Int]):Array[Boolean] = {
    for(num <- arr) yield if(num % 2 == 0) {true} else {false}
  }
}

main.main()
