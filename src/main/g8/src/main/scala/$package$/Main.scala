package $package$

import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}
import $package$.Conf._
import $package$.Session

object Main extends LazyLogging {

  def main(args: Array[String]): Unit = {

    logger.info("Starting $name$")

  }
}
