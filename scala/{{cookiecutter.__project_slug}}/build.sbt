ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "{{cookiecutter.__project_slug}}"


lazy val {{cookiecutter.__project_slug}} = project
  .in(file("."))
  .settings(
    name := "{{cookiecutter.__project_slug}}",
    libraryDependencies ++= Seq(
      "org.scala-lang" %% "toolkit-test" % "0.1.7" % Test
    ),
  )


