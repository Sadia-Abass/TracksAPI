package com.bbcsounds.tracksapi.server

import cats.effect.{ExitCode, IO}
import cats.effect.kernel.Async
import cats.effect.std.Console
import com.bbcsounds.tracksapi.config.{Config, ServerConfig}
import com.bbcsounds.tracksapi.route.Endpoints
import org.http4s.blaze.server.BlazeServerBuilder
import fs2.Stream
import cats.implicits._
import cats.syntax.MonadSyntax
import com.bbcsounds.tracksapi.config.Config.config
import com.bbcsounds.tracksapi.domain.Track
//import com.bbcsounds.tracksapi.services.TrackServices.TrackServices
import org.http4s.Request
import org.http4s.server.{DefaultServiceErrorHandler, Router}
import sun.rmi.transport.Endpoint

import java.util.UUID
import scala.concurrent.duration.DurationInt
import scala.concurrent.ExecutionContext.global



object Server {

//  private val services: TrackServices = new TrackServices
//
//  val api = Router(
//     // "/" -> Endpoints.trackRoute.apply
//      "/api" -> Endpoints.trackRoute(services)
//  ).orNotFound
//
//
//  def stream[[IO]: Async: Console](config: Config): fs2.Stream[IO, ExitCode] =
//    for {
//      _ <- Stream.eval((Console[IO].println("Starting server")))
//      server <- BlazeServerBuilder[IO]
//        .bindHttp(
//          config.serverConfig.port.value,
//          config.serverConfig.host.value
//        )
//        .withHttpApp(api)
//        .serve
//    } yield server
//  }


}
