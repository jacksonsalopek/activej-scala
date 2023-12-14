package io.skintracker

import io.activej.http.{AsyncServlet, HttpResponse}
import io.activej.inject.annotation.Provides
import io.activej.launcher.Launcher
import io.activej.launchers.http.MultithreadedHttpServerLauncher
import io.activej.worker.annotation.{Worker, WorkerId}

object MultiThreaded extends MultithreadedHttpServerLauncher {
  @Provides
  @Worker
  def servlet(@WorkerId workerId: Int): AsyncServlet = { request =>
    HttpResponse
      .ok200()
      .withHtml(html.index("Worker #" + workerId).toString())
      .toPromise()
  }

  def main(args: Array[String]): Unit = {
    val launcher: Launcher = MultiThreaded
    launcher.launch(args)
  }
}
