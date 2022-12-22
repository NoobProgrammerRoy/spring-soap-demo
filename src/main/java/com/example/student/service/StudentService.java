package com.example.student.service;

import org.springframework.stereotype.Service;

import com.example.student.api.soap.studentevaluation.StudentDetailsRequest;
import com.example.student.api.soap.studentevaluation.StudentEvaluationResponse;

@Service
public class StudentService {
  public StudentEvaluationResponse evaluateStudent(StudentDetailsRequest request) {
    var response = new StudentEvaluationResponse();

    if (request.getPercentage() < 40) {
      response.setResult("Fail");
      response.setGrade("F");
    } else if (request.getPercentage() < 60) {
      response.setResult("Second Class");
      response.setGrade("B");
    } else if (request.getPercentage() < 80) {
      response.setResult("First Class");
      response.setGrade("A");
    } else {
      response.setResult("Distinction");
      response.setGrade("S");
    }

    return response;
  }
}
