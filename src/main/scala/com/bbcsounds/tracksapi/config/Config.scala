package com.bbcsounds.tracksapi.config

import cats.effect.kernel.Async
import ciris.ConfigValue

final case class Config(serverConfig: ServerConfig)

object Config{
  def config[F[_]: Async]: ConfigValue[F, Config] = (
    ServerConfig.serverConfig[F]
  ).map(serverConfig => Config(serverConfig))
}