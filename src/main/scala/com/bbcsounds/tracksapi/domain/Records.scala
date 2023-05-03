package com.bbcsounds.tracksapi.domain

import java.util.UUID

object Records {

  val record1: Track = Track(
    "nznx3r",
    "track",
    "urn:bbc:sounds:track:nznx3r",
    titles = new Titles("AC/DC", "Highway to Hell", null),
    availability = new Availability("2019-02-13T11:03:05Z", "2019-03-15T11:00:00Z", "Available for 29 days")
  )

  val tracks: Map[String, Track] = Map(record1.id -> record1)


}
