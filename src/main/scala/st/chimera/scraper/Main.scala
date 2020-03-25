package st.chimera.scraper

import net.htmlparser.jericho._
import st.chimera.scraper.HtmlScraper._

object Main {
  def main(args: Array[String]) {
    val doc = HtmlScraper("https://www.baidu.com/")
    println(doc)
    println("-" * 22)
    doc.eval("//a").foreach(_ match {
      case node: Segment =>
        node.eval("text()").foreach(println)
        node.eval("@href").foreach(_ match {
          case attr: Attribute => println("  " + attr.getValue)
        })
    })
  }
}
