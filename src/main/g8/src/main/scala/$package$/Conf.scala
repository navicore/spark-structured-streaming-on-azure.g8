package $package$

import com.typesafe.config.ConfigFactory
import org.apache.hadoop.conf.Configuration
import org.apache.log4j.{BasicConfigurator, Level, LogManager}
import org.json4s.DefaultFormats

object Conf {

  val config = ConfigFactory.load()
  val appName: String           = config.getString("main.appName")
  val logLevel: String          = config.getString("main.logLevel")
  val sparkMaster = config.getString("spark.master")
  val batchDuration = config.getInt("spark.batchDuration")

  val checkpointPath = config.getString("spark.checkpointPath")
  val checkpointAccount = config.getString("spark.checkpointAccount")
  val checkpointKey = config.getString("spark.checkpointKey")
  val hadoopConf = new Configuration()
  hadoopConf.set("fs.azure", "org.apache.hadoop.fs.azure.NativeAzureFileSystem")
  hadoopConf.set(s"fs.azure.account.key.\$checkpointAccount.blob.core.windows.net", checkpointKey)

}
