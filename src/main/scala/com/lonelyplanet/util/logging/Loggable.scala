package com.lonelyplanet.util.logging

import org.slf4j.LoggerFactory

trait Loggable {
  def logger = LoggerFactory.getLogger(this.getClass)
}
