//iterates chars

class CharIter(input:String) {
	var done:Boolean = false;
	var index:Int = 0;
	val limit:Int = input.length;
	def apply():Char = {
		if(done) '\0'
		else {
			val hold = input(index);
			index += 1;
			check();
			return hold;
		}
	}

	private def check():Unit = if(index == limit) {
			done = true;
		 }
	
}
