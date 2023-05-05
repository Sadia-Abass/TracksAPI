package com.bbcsounds.tracksapi.route

import cats.effect.IO
import org.http4s.circe._
import com.bbcsounds.tracksapi.domain.Track
import com.bbcsounds.tracksapi.services.TracksData
import org.http4s.{HttpRoutes, _}
import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s.headers._
import org.http4s.circe.jsonOf
import org.http4s.dsl.Http4sDsl

object Endpoints{
 def trackRoute(trackData: TracksData): HttpRoutes[IO] = {
    val dsl = Http4sDsl[IO]
   import dsl._
   implicit val trackDecoder: EntityDecoder[IO, Track] = jsonOf[IO, Track]
   implicit val trackEncoder: EntityEncoder.Pure[Track] = jsonEncoderOf[Track]

      HttpRoutes.of[IO] {
        case GET -> Root / "tracks" / trackId =>
          trackData.getTrackById(trackId).flatMap { //flatMap
            case Some(track) => Ok(track.asJson)
            case _ => NotFound(s"No track with id $trackId found")
          }
      case req @ POST -> Root / "tracks" =>
      for {
         trackRecord <- req.as[Track]
         _ = trackData.createTrack(trackRecord)
         response <- Ok.headers(`Content-Encoding`(ContentCoding.gzip))
           .map(_.addCookie(ResponseCookie("My-Cookie", "value")))
         } yield response

      }

 }
}



