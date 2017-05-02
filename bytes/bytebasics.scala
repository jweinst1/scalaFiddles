//byte buffer
//byte buffer examples with nio ByteBuffer in scala

import java.nio.ByteBuffer

object main  {
  def main():Unit = {
    var g = ByteBuffer.allocate(8);
    g.putInt(8);
    g.putInt(7);
    println(g.getInt(0));
    println(g.getInt(4));
    println(g.toString);
    println(g.array())
  }
}

main.main();
