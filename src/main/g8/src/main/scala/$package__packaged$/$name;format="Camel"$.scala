package $package$

import cats.effect.{IO, IOApp}

object $name;format="Camel"$ extends IOApp.Simple {
  override def run: IO[Unit] = IO.println("Hello, world!")
}
