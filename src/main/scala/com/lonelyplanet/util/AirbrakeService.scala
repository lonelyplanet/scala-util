package com.lonelyplanet.util

import airbrake.{AirbrakeNoticeBuilder, AirbrakeNotifier}
import com.lonelyplanet.util.logging.Loggable

class AirbrakeService(apiKey: String, environment: String) extends Loggable {
  private val notifier: AirbrakeNotifier = new AirbrakeNotifier()
  private val isAirbrakeConfigured = apiKey != ""

  if (!isAirbrakeConfigured) {
    logger.warn("Airbrake key is not configured")
  } else {
    logger.info("Airbrake configured correctly")
  }

  def notify(error: Throwable, url: String, component: String): Unit = {
    if (isAirbrakeConfigured) {
      val notice = new AirbrakeNoticeWithUrlBuilder(apiKey, error, environment)
        .withUrl(url, component)
        .build()

      notifier.notify(notice)
    }
  }

  def notify(error: Throwable): Unit = {
    if (isAirbrakeConfigured) {
      val notice = new AirbrakeNoticeBuilder(apiKey, error, environment).newNotice()
      notifier.notify(notice)
    }
  }
}
