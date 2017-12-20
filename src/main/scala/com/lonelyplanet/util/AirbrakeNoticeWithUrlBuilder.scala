package com.lonelyplanet.util

import airbrake.{AirbrakeNotice, AirbrakeNoticeBuilder}

class AirbrakeNoticeWithUrlBuilder(apiKey: String, error: Throwable, environment: String)
    extends AirbrakeNoticeBuilder(apiKey, error, environment) {

  def withUrl(url: String, component: String): AirbrakeNoticeWithUrlBuilder = {
    setRequest(url, component)
    this
  }

  def build(): AirbrakeNotice = {
    newNotice()
  }
}
