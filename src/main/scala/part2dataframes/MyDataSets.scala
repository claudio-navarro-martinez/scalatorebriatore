package part2dataframes

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._

object MyDataSets extends App {
    val spark = SparkSession.builder()
        .appName("DataFrames Basics")
        .config("spark.master", "local")
        .getOrCreate()
     val carsSchema = StructType(Array(
        StructField("Name", StringType),
        StructField("Miles_per_Gallon", DoubleType),
        StructField("Cylinders", LongType),
        StructField("Displacement", DoubleType),
        StructField("Horsepower", LongType),
        StructField("Weight_in_lbs", LongType),
        StructField("Acceleration", DoubleType),
        StructField("Year", StringType),
        StructField("Origin", StringType)
    ))

    val carsDF = spark.read
        .format("json")
        .schema(carsSchema)
        .option("mode","failFast")
        .load("/home/claudiomartinez/scala/spark/spark-essentials/src/main/resources/data/cars.json")
}