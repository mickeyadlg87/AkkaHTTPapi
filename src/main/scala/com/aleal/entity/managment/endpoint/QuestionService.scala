package com.aleal.entity.managment.endpoint

import akka.http.scaladsl.server.Route
import com.aleal.entity.managment.model.QuestionModel
import com.aleal.entity.managment.service.MyResource
import com.aleal.entity.managment.vo.{Question, QuestionUpdate}

/**
  * Created by aleal on 07/04/17.
  */
trait QuestionService extends MyResource {

  val questionService: QuestionModel

  def questionRoutes: Route = pathPrefix("questions") {
    pathEnd {
      post {
        entity(as[Question]) { question =>
          completeWithLocationHeader(
            resourceId = questionService.createQuestion(question),
            ifDefinedStatus = 201, ifEmptyStatus = 409)
        }
      }
    } ~
      path(Segment) { id =>
        get {
          complete(questionService.getQuestion(id))
        } ~
          put {
            entity(as[QuestionUpdate]) { update =>
              complete(questionService.updateQuestion(id, update))
            }
          } ~
          delete {
            complete(questionService.deleteQuestion(id))
          }
      }
  }

}
