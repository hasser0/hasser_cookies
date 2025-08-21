import mill._
import scalalib._

object {{ cookiecutter.__project_slug }} extends ScalaModule {
  def scalaVersion = "{{ cookiecutter.scala_version }}"
}
