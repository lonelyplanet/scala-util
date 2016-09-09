package com.lonelyplanet.util

import airbrake.{AirbrakeNoticeBuilder, AirbrakeNotifier}
import com.lonelyplanet.util.logging.Loggable

class AirbrakeService(key: String, environment: String) extends Loggable {
  private val notifier: AirbrakeNotifier = new AirbrakeNotifier()
  private val isAirbrakeConfigured = key != ""

  if (!isAirbrakeConfigured) {
    logger.warn("Airbrake key is not configured")
  } else {
    logger.info("Airbrake configured correctly")
  }

  def notify(e: Throwable) = {
    if (isAirbrakeConfigured) {
      val notice = new AirbrakeNoticeBuilder(key, e, environment).newNotice()
      notifier.notify(notice)
    }
  }
}
