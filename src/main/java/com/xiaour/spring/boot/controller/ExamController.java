package com.xiaour.spring.boot.controller;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.entity.Exam;
import com.xiaour.spring.boot.request.ExamReq;
import com.xiaour.spring.boot.request.SubmitPaperReq;
import com.xiaour.spring.boot.response.BaseResponse;
import com.xiaour.spring.boot.service.ExamManageService;
import com.xiaour.spring.boot.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamManageService examManageService;

    @Autowired
    private ExamService examService;

    @PostMapping("/add")
    public String addExam(@RequestBody String data) {
        data = data.replace("\\","");
        data = data.replace("{\"data\":\"","");
        data = data.substring(0,data.length()-2);
        ExamReq exam = JSON.parseObject(data, ExamReq.class);
        BaseResponse baseResponse = new BaseResponse();
        if(examManageService.addExam(exam)) {
            baseResponse.setCode(200);
            baseResponse.setMessage("true");
            return baseResponse.toString();
        }
        baseResponse.setCode(1000);
        baseResponse.setMessage("false");
        return baseResponse.toString();
    }

    @GetMapping("/del")
    public String delExam(int examId) {
        BaseResponse baseResponse = new BaseResponse();
        if(examManageService.delExam(examId)) {
            baseResponse.setCode(200);
            baseResponse.setMessage("true");
            return baseResponse.toString();
        }
        baseResponse.setCode(1000);
        baseResponse.setMessage("false");
        return baseResponse.toString();
    }

    @PostMapping("/update")
    public String updateExam(@RequestBody String data) {
        data = data.replace("\\","");
        data = data.replace("{\"data\":\"","");
        data = data.substring(0,data.length()-2);
        ExamReq exam = JSON.parseObject(data, ExamReq.class);
        BaseResponse baseResponse = new BaseResponse();
        if(examManageService.updateExam(exam)) {
            baseResponse.setCode(200);
            baseResponse.setMessage("true");
            return baseResponse.toString();
        }
        baseResponse.setCode(1000);
        baseResponse.setMessage("false");
        return baseResponse.toString();
    }

    @GetMapping("/getAll")
    public String getAllExam() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(examManageService.getAllExam());
        return JSON.toJSONString(baseResponse);
    }

    @GetMapping("/get")
    public String getExam(Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(examManageService.getExamByUser(id));
        return JSON.toJSONString(baseResponse);
    }

    @GetMapping("/getByModel")
    public String getExamByModel(Integer model) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(examManageService.getExamByModel(model));
        return JSON.toJSONString(baseResponse);
    }

    @GetMapping("/getPaper")
    public String getPaper(Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(examService.getPaper(id));
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        return JSON.toJSONString(baseResponse);
    }

    @PostMapping("/submitPaper")
    public String submitPaper(@RequestBody String data) {
        data = data.replace("\\","");
        data = data.replace("{\"data\":\"","");
        data = data.substring(0,data.length()-2);
        SubmitPaperReq req = JSON.parseObject(data, SubmitPaperReq.class);
        System.out.println(JSON.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        if(examService.saveAnswer(req)) {
            baseResponse.setCode(200);
            baseResponse.setMessage("true");
        } else {
            baseResponse.setCode(1000);
            baseResponse.setMessage("false");
        }
        return JSON.toJSONString(baseResponse);
    }

}
