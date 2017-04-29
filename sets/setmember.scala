object main {
  def main(args:Array[String]):Unit = {
    println(Parser.ignoreTokens('t'))
  }
}

object Parser {
  val ignoreTokens = Set(' ', '\n', '\t', '\r');
}

main.main(Array());
