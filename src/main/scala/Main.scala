import org.apache.spark.sql.SparkSession

object Main extends App {
  val  spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .master("local[0]")
      .getOrCreate()
  import spark.implicits._
  val s = Seq(10,11,12,13,14,15)    
  val ds = s.toDS()
  val df = spark.read.json()
  println("Hello, World!")
} 