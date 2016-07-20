package com.lonelyplanet.util.logging

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.spi.LoggingEvent
import ch.qos.logback.core.spi.FilterReply

class StdOutFilter extends ch.qos.logback.core.filter.AbstractMatcherFilter {
  private val allowed = Set(Level.TRACE, Level.DEBUG, Level.INFO)

  override def decide(event: Nothing): FilterReply = {
    if (!isStarted) {
      FilterReply.NEUTRAL
    } else {
      val loggingEvent: LoggingEvent = event.asInstanceOf[LoggingEvent]

      if (allowed.contains(loggingEvent.getLevel)) {
        FilterReply.NEUTRAL
      } else {
        FilterReply.DENY
      }
    }
  }
}
