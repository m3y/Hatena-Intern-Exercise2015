package hatena.intern

import hatena.intern.helper._

class Exercise2Spec extends UnitSpec {

  describe("LTSV Parser") {
    it("LTSVファイルが正しくパースされていること") {
      val logs = LtsvParser.parse("../sample_data/log.ltsv")
      logs.size shouldBe 5

      // 以降ファイルが正しくLogクラスにパースされているテストを書いてみてください
      logs.toList(0).size shouldBe 2326
      logs.toList(0).status shouldBe 200
      logs.toList(0).user.get shouldBe "frank"
      logs.toList(0).referer.get shouldBe "http://www.hatena.ne.jp/"

      logs.toList(1).size shouldBe 1234
      logs.toList(1).status shouldBe 200
      logs.toList(1).user.get shouldBe "john"
      logs.toList(1).referer.get shouldBe "http://b.hatena.ne.jp/hotentry"

      logs.toList(2).size shouldBe 9999
      logs.toList(2).status shouldBe 503
      logs.toList(2).user shouldBe None
      logs.toList(2).referer.get shouldBe "http://www.example.com/start.html"

      logs.toList(3).size shouldBe 2326
      logs.toList(3).status shouldBe 500
      logs.toList(3).user.get shouldBe "frank"
      logs.toList(3).referer.get shouldBe "http://www.hatena.ne.jp/"

      logs.toList(4).size shouldBe 100
      logs.toList(4).status shouldBe 404
      logs.toList(4).user.get shouldBe "frank"
      logs.toList(4).referer shouldBe None
    }

    it("LTSVファイルが正しくパースできない形式の場合") {
      // エラーハンドリングの設計を考えながら、テストを書いてみてください
    }

    it("LTSVファイルが存在しない場合") {
      // エラーハンドリングの設計を考えながら、テストを書いてみてください
    }
  }

}
