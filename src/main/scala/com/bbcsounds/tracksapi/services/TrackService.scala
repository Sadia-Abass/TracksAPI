package com.bbcsounds.tracksapi.services

import cats.effect._
import com.bbcsounds.tracksapi.domain.{Availability, Titles, Track}

import java.util.UUID

trait TracksData {
  def getTrackById(trackId: String): IO[Option[Track]]
  def createTrack(track: Track): IO[Option[String]]
  def delete(trackId: String): IO[Unit]
}

object TracksData {
class TrackServices extends TracksData { //(val track: List[Tracks])

    val record1: Track = Track(
      "nznx3r",
      "track",
      "urn:bbc:sounds:track:nznx3r",
      titles = new Titles("AC/DC", "Highway to Hell", None),
      availability = new Availability("2019-02-13T11:03:05Z", "2019-03-15T11:00:00Z", "Available for 29 days"))


    var tracksDB = List(record1)

  def getTrackById (trackId: String)  =

    IO {
    val result =  tracksDB.find(_.id == trackId).flatMap(Option[Track])

      println(result)
      //tracksDB.map()

      result

  }


    def createTrack(track: Track): IO[Option[String]] = IO {
      tracksDB.find(_.id != Track) match {
        case Some(value) => None
        case None =>
          tracksDB = tracksDB :+ track
          Some(track.id)
      }
    }

//    def updateTrack(id: Track, trackUpdate: Track): IO[Unit] = {
//
//    }

    def delete(trackId: String): IO[Unit] = IO {
      tracksDB = tracksDB.filterNot(_.id == trackId)
    }

  }
}