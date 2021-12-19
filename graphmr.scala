import scala.collection.mutable.Map

object gmr {

def map(line:String):Map[Int,(Int,Int)]={
	val nodes = line.split("\t").map((x)=>x.toInt).toArray
	val map = Map[Int,(Int,Int)]()
	val vin = nodes(0)
	val vout = nodes(1)
	map.addOne((vin,(0,1)))
	if(map.contains(vout)){
		val old = map(vout)
		map.update(vout,(1,1))
	}else{
		map.addOne((vout,(1,0)))
	}
	return map
}

def reduce(m1:Map[Int,(Int,Int)],m2:Map[Int,(Int,Int)]):Map[Int,(Int,Int)]={

	for(v<-m2.toArray){
		if(m1.contains(v._1)){
			val m11 = m1(v._1)
			m1.update(v._1,(m11._1+v._2._1,m11._2+v._2._2))
		}else{
			m1.addOne(v)
		}
	}
	return m1
}

def main(args: Array[String]): Unit = {
	var mbefore = Map[Int,(Int,Int)]()
	io.Source.fromFile("graph.txt").getLines.foreach(l =>{var mcurrent = map(l);var red = reduce(mbefore, mcurrent);mbefore = red})


}
}


