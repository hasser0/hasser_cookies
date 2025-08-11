import mill._
import scalalib._

object foo extends ScalaModule {
  def scalaVersion = "{{ cookiecutter.scala_version }}"

  object test extends Tests {
    def ivyDeps = Agg(ivy"com.lihaoyi::utest:0.9.0")
    def testFramework = "utest.runner.Framework"
  }
}
