package com.example.student.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.student.api.soap.studentevaluation.StudentDetailsRequest;
import com.example.student.api.soap.studentevaluation.StudentEvaluationResponse;
import com.example.student.service.StudentService;

@Endpoint
public class StudentEvaluationEndpoint {
  @Autowired
  private StudentService service;

  @PayloadRoot(namespace = "http://student.example.com/api/soap/studentevaluation", localPart = "StudentDetailsRequest")
  @ResponsePayload
  public StudentEvaluationResponse evaluateStudent(@RequestPayload StudentDetailsRequest request) {
    return service.evaluateStudent(request);
  }
}
