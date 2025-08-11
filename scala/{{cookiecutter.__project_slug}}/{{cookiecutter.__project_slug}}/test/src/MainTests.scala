package {{ cookiecutter.__project_slug }}
import utest._

object MainTests extends TestSuite {
  def tests = Tests {
    test("msg") {
      val result = Main.hello()
      assert(result == "Hello world")
      result
    }
  }
}
