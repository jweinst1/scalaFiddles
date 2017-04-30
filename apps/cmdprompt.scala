package kankan

import scalaj.http._

object main extends App {
	for(i <- List.range(0, 10) if i % 2 != 0) {println(s"$i ----")}
	val name = readLine("What's your name? ")
	println(name);
}
