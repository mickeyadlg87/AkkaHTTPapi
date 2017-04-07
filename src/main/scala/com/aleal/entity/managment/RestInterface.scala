package com.aleal.entity.managment

import akka.http.scaladsl.server.Route
import com.aleal.entity.managment.endpoint.QuestionService
import com.aleal.entity.managment.model.QuestionModel

import scala.concurrent.ExecutionContext

/**
  * Created by aleal on 07/04/17.
  */
trait RestInterface extends Resources {
  implicit def executionContext: ExecutionContext

  lazy val questionService = new QuestionModel

  val routes: Route = questionRoutes
}

trait Resources extends QuestionService