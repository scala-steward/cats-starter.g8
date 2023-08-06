# Sbt Cats/GraalVM Starter

A [Giter8][g8] template to bootstrap a Scala 3 Cats/CE3 project that can be compiled to a native image with Docker,
alongside some useful addons and common dependencies.

## Usage

Create a new project:

```bash
sbt new lowmelvin/cats-starter.g8
```

Build a native image and then run it with Docker:

```bash
docker build -t cats .
docker run --rm cats
```

## Template license

Written in 2023 by Melvin Low <me@melvinlow.com>.

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
