package scala
import utest._

object MainTests extends TestSuite {
  def tests = Tests {
    test("msg") {
      assert("Hello world" == "Hello world")
      "Hello world"
    }
  }
}
