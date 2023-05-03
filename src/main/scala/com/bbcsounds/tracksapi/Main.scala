package com.bbcsounds.tracksapi

import cats.effect.{ExitCode, IO, IOApp}
import com.bbcsounds.tracksapi.route.Endpoints
import org.http4s.server.Router
import org.http4s.blaze.server.BlazeServerBuilder
import com.bbcsounds.tracksapi.services.TracksData
import com.bbcsounds.tracksapi.services.TracksData.TrackServices
import org.http4s.{HttpRoutes, Request}

import org.http4s.dsl.io._
object Main extends IOApp {

  private val services: TracksData = new TrackServices
  val hello = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name =>
      Ok(s"Hello, $name.")
  }

  val api = Router(mappings =
    "/" -> hello,
    "/api" -> Endpoints.trackRoute(services)
  ).orNotFound

  override def run(args: List[String]): IO[ExitCode] = {

       BlazeServerBuilder[IO]
      .bindHttp(8080, "0.0.0.0"
//        config.serverConfig.port.value,
//        config.serverConfig.host.value
      )
      .withHttpApp(api)
      .serve
     .compile
     .drain
     .as(ExitCode.Success)
//    (
//      for {
//        config <- Stream.eval(Config.config[IO].load)
//        server <- Server.stream[IO](config)
//      } yield server
//      ).compile.drain.as(ExitCode.Success)
  }
}