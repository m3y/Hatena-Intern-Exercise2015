package hatena.intern

import scalax.file.Path

object LtsvParser {
  def parse(filePath: String): Iterable[Log] = {

    def convertOption(v: String): Option[String] = {
      v match {
        case "-" => None
        case _ => Option(v)
      }
    }

    // File -> String -> List[Map]
    val tokens = for {
      line <- Path.fromString(filePath).lines()
      token = line.split("\t").map(x => x.split(":", 2)).map(pair => pair(0) -> pair(1)).toMap
    } yield token

    // List[Map] -> List[Log]
    tokens.toList.map { token =>
      Log(
        host = token("host"),
        user = convertOption(token("user")),
        epoch = token("epoch").toInt,
        req = token("req"),
        status = token("status").toInt,
        size = token("size").toInt,
        referer = convertOption(token("referer"))
      )
    }
  }
}
