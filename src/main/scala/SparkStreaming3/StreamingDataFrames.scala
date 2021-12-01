package SparkStreaming3

import org.apache.spark.sql.SparkSession

object StreamingDataFrames {
    val spark = SparkSession.builder()
            .appName("Our first streams")
            .config("spark.master", "local[2]")
            .getOrCreate()
    def readFromSocket() = {
        var lines =  spark.readStream
            .format("socket")
            .option("host","localhost")
            .option("port",12345)
            .load()
        val query = lines.writeStream
                    .format("console")
                    .outputMode("append")
                    .start()
                    .awaitTermination()
    } 
    def main(args: Array[String]): Unit = {
        readFromSocket()
    }
}