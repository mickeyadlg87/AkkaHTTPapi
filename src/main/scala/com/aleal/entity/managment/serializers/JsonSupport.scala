package com.aleal.entity.managment.serializers

import java.text.SimpleDateFormat

import de.heikoseeberger.akkahttpjson4s.Json4sSupport
import org.json4s.ext.JodaTimeSerializers
import org.json4s.{native, DefaultFormats, Formats}

/**
  * Created by aleal on 07/04/17.
  */
trait JsonSupport extends Json4sSupport {

  implicit val serialization = native.Serialization

  implicit def json4sFormats: Formats = customDateFormat ++ JodaTimeSerializers.all ++ CustomerSerializers.all

  val customDateFormat = new DefaultFormats {
    override def dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
  }

}
