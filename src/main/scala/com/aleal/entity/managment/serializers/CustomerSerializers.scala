package com.aleal.entity.managment.serializers

import java.sql.Timestamp

import org.json4s.CustomSerializer
import org.json4s.JsonAST.{JInt, JNull}

/**
  * Created by aleal on 07/04/17.
  */
object CustomerSerializers {
  val all = List(CustomTimestampSerializer)
}

case object CustomTimestampSerializer extends CustomSerializer[Timestamp](format =>
  ({
    case JInt(x) => new Timestamp(x.longValue * 1000)
    case JNull => null
  },
    {
      case date: Timestamp => JInt(date.getTime / 1000)
    }))
