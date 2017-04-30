//regex matching
//gets all the matches from text

object main {
  def main():Unit = {
    val text = raw">([a-z0-9A-Z .,?!]+?)<".r
    val allText = for (m <- text.findAllMatchIn(strs.tester)) yield m.group(1);
    for (t <- allText) {
      println(t);
    }
    
  }
}


object strs {
  val tester = """<p>hello sir</p><a>how is it sire</a><p>wonderfull!</p>"""
}

main.main();
