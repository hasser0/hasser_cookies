package {{ cookiecutter.__project_slug }}

object Main {
  def msg(): String = "Hello world"

  def main(args: Array[String]): Unit = {
    println(msg())
  }
}
