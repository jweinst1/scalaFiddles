package example

import scalaj.http._

object Hello extends App {
  println(<a></a>);
  println(xmltest.x());
  val l = 
  <order>
    <item name="Pizza" price="12.00">
      <pizza>
        <crust type="thin" size="14" />
        <topping>cheese</topping>
        <topping>sausage</topping>
      </pizza>
    </item>
    <item name="Breadsticks" price="4.00">
      <breadsticks />
    </item>
    <tax type="federal">0.80</tax>
    <tax type="state">0.80</tax>
    <tax type="local">0.40</tax>
  </order>
  println(l.child(0).label);
  println(l.child(1));
  println(l.child(1).label);
  println(l.child.length);
  val request = Http("http://reddit.com/").asString;
  val d = scala.xml.XML.loadString(request.toString);
  println(d);

}

object xmltest {
	def x():scala.xml.Elem = <a><b>hello</b><b>yo</b></a>;
}
