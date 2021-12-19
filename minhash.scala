import scala.collection.mutable.Set
object mh {

def main(args: Array[String]): Unit = {
	val k = args(2).toInt
	var n = args(3).toInt
	var bookfile1 = scala.io.Source.fromFile(args(0))
	var bookfile2 = scala.io.Source.fromFile(args(1))
	var text = try bookfile1.mkString finally bookfile1.close()
	var texttoadd = text.toLowerCase().replaceAll("\\p{Punct}", "")
	var wordset1 = texttoadd.split("\\s+")
	text = try bookfile2.mkString finally bookfile2.close()
	texttoadd = text.toLowerCase().replaceAll("\\p{Punct}", "")
	var wordset2 = texttoadd.split("\\s+")

	var ksh1 = Set[String]()
	var ksh2 = Set[String]()

	for(i <- 0 to wordset1.length - k){
		var arr = ""
		for (j <- 0 to k-1) arr = arr + " " + wordset1(i+j)
		ksh1 += arr
	}
	for(i <- 0 to wordset2.length - k){
		var arr = ""
		for (j <- 0 to k-1) arr = arr + " " + wordset2(i+j)
		ksh2 += arr
	}
	//ksh1.foreach(println)
	//ksh2.foreach(println)
	var inter = (ksh1&ksh2).size.asInstanceOf[Double]
	var union = (ksh1|ksh2).size.asInstanceOf[Double]
	var jaccsim = inter/union

	var harr1 = Array[Array[Int]]()
	var harr2 = Array[Array[Int]]()
	for(i <- 0 to n-1){
		harr1:+=scala.util.Random.shuffle(List.range(0, ksh1.size)).toArray
		harr2:+=scala.util.Random.shuffle(List.range(0, ksh2.size)).toArray
	}	
	

}
}
