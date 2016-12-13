# scala-util

[![Join the chat at https://gitter.im/lonelyplanet/scala-util](https://badges.gitter.im/lonelyplanet/scala-util.svg)](https://gitter.im/lonelyplanet/scala-util?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/lonelyplanet/scala-util.svg?branch=master)](https://travis-ci.org/lonelyplanet/scala-util)
[![codecov](https://codecov.io/gh/lonelyplanet/scala-util/branch/master/graph/badge.svg)](https://codecov.io/gh/lonelyplanet/scala-util)
[![Download](https://api.bintray.com/packages/lonelyplanet/maven/scala-util/images/download.svg) ](https://bintray.com/lonelyplanet/maven/scala-util/_latestVersion)

A collections of random Scala utilities


    "com.lonelyplanet" %% "scala-util" % "0.2.2"

You might need to also add our repository:

```
resolvers ++= Seq(
  Resolver.bintrayRepo("lonelyplanet", "maven")
)
```

# What's included:
#### URI Matches for scalatest
A simple matcher that provides more custom matching rules for URIs, for example: matching URIs without looking at the ordering of query parameters (which wouldn't work if you just compare `String`s)

#### Std{Err,Out}Filter
A logback filter that redirects `ERROR` and `WARN` logs to `stderr` and, `TRACE`, `DEBUG`, `INFO` are redirected to `stdout`

#### AirbrakeService
A simple wrapper that is used to send notifications about errors to Airbrake

#### OptionConversions
A collection of utilities for converting `Option`s

### Publishing

We use `bintray-sbt` plugin for publishing artifacts, to publish newer version of the library run:
```
sbt publish
```

That's all what is required
