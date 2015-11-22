package hatena.intern

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format._

case class Log(host: String, user: Option[String], epoch: Int, req: String, status: Int, size: Int, referer: Option[String]) {
  def method: String = req.split(" ")(0)
  def path: String = req.split(" ")(1)
  def protocol: String = req.split(" ")(2)
  def uri: String = "http://%s%s".format(host, path)
  def time: String = {
    val dt = new DateTime(epoch * 1000L, DateTimeZone.UTC)
    DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss").print(dt)
  }
}
