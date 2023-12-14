package io.skintracker

import io.activej.http.{AsyncServlet, HttpResponse}
import io.activej.inject.annotation.Provides
import io.activej.launcher.Launcher
import io.activej.launchers.http.HttpServerLauncher

object Main extends HttpServerLauncher {
  @Provides
  def servlet(): AsyncServlet = { request =>
    HttpResponse
      .ok200()
      .withHtml(html.index("World").toString())
      .toPromise()
  }

  def main(args: Array[String]): Unit = {
    val launcher: Launcher = Main
    launcher.launch(args)
  }
}
