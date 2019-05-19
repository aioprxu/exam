package com.xiaour.spring.boot.controller;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.entity.Paper;
import com.xiaour.spring.boot.request.AddPaperReq;
import com.xiaour.spring.boot.request.PaperReq;
import com.xiaour.spring.boot.response.BaseResponse;
import com.xiaour.spring.boot.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @PostMapping("/add")
    public String addExam(@RequestBody String data) {
        data = data.replace("\\","");
        data = data.replace("{\"data\":\"","");
        data = data.substring(0,data.length()-2);
        AddPaperReq paper = JSON.parseObject(data, AddPaperReq.class);
        BaseResponse baseResponse = new BaseResponse();
        if(paperService.addPaper(paper)) {
            baseResponse.setCode(200);
            baseResponse.setMessage("true");
            return baseResponse.toString();
        }
        baseResponse.setCode(1000);
        baseResponse.setMessage("false");
        return baseResponse.toString();
    }

    @GetMapping("/del")
    public String delExam(int id) {
        BaseResponse baseResponse = new BaseResponse();
        if(paperService.delPaper(id)) {
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
        PaperReq paper = JSON.parseObject(data, PaperReq.class);
        BaseResponse baseResponse = new BaseResponse();
        if(paperService.updatePaper(paper)) {
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
        baseResponse.setData(paperService.getAllPaper());
        return JSON.toJSONString(baseResponse);
    }


    @GetMapping("/getByModel")
    public String getExamByModel(Integer model) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(paperService.getPaperByModel(model));
        return JSON.toJSONString(baseResponse);
    }

    @GetMapping("/file")
    public String file(Integer examId){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("true");
        baseResponse.setData(paperService.getFile(examId));
        return JSON.toJSONString(baseResponse);
    }

}
