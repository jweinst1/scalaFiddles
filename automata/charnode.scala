// Node examples for regex engne


object main {
  def main() {
    val g = SingleNode('r');
    println(g('e'));
    println(g('s'));
  }
}

abstract class MatchNode;

case class SingleNode(c:Char) extends MatchNode {
  def apply(other:Char):Boolean = other == c;
}



main.main()
