package $package$

import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.sql.SparkSession
import $package$.Conf._

object Session extends LazyLogging {

  def apply(): SparkSession = {
    val session = SparkSession
      .builder()
      .appName(appName)
      .master(sparkMaster)
      .getOrCreate()

    session.sparkContext.hadoopConfiguration.set("fs.azure", "org.apache.hadoop.fs.azure.NativeAzureFileSystem")
    session.sparkContext.hadoopConfiguration.set(s"fs.azure.account.key.\$checkpointAccount.blob.core.windows.net", checkpointKey)
    logger.info(s"using checkpoint azure blob account \$checkpointAccount")

    session
  }
}

