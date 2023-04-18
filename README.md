# G8 Cats/CE3/GraalVM template

A [Giter8][g8] template to bootstrap a Cats/CE3 project using Scala 2.13. 
A Dockerfile is provided to build a native image with GraalVM with a memory limit (-Xmx512m)
for demonstration purposes.

If running Docker on Mac/Windows, you may need at least 6GB of memory allocated to Docker
for the native image to build successfully.

A few other addons are provided, such as Scalafix and Scalafmt rules and
some commonly used Scala libraries/plugins.

## Template license
Written in 2023 by rzqx <rzqx@pm.me>.

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
