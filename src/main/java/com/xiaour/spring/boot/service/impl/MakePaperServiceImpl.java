package com.xiaour.spring.boot.service.impl;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.xiaour.spring.boot.constant.Constant;
import com.xiaour.spring.boot.entity.Paper;
import com.xiaour.spring.boot.mapper.PaperMapper;
import com.xiaour.spring.boot.service.MakePaperService;
import com.xiaour.spring.boot.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

//组卷策略，选择题20道，10道通用，10道专有，共40分，判断10道，共10分，填空10道，20分，主观3道，30分
public class MakePaperServiceImpl implements MakePaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public String getPaper(String model) {
        List<Paper> paperList = new ArrayList<>();
        paperList.addAll(get20ChoiceQuestion(model));
        paperList.addAll(get10FillBlankQuestion(model));
        paperList.addAll(get10JudgeQuestion(model));
        paperList.addAll(get3SubjectiveQuestion(model));
        return JsonUtil.getJsonString(paperList);
    }

    private List<Paper> get20ChoiceQuestion(String model) {
        List<Paper> paperList1 = paperMapper.getPaperByModelAndType(model, Constant.ChoiceQuestion);
        List<Paper> resPaperList = new ArrayList<>();
        getRandomQuestion(10, paperList1, resPaperList);
        List<Paper> paperList2 = paperMapper.getPaperByModelAndType(Constant.Normal, Constant.ChoiceQuestion);
        getRandomQuestion(10, paperList2, resPaperList);
        return resPaperList;
    }

    private List<Paper> get10FillBlankQuestion(String model) {
        List<Paper> paperList1 = paperMapper.getPaperByModelAndType(model, Constant.FillBlankQuestion);
        List<Paper> resPaperList = new ArrayList<>();
        getRandomQuestion(5, paperList1, resPaperList);
        List<Paper> paperList2 = paperMapper.getPaperByModelAndType(Constant.Normal, Constant.FillBlankQuestion);
        getRandomQuestion(5, paperList2, resPaperList);
        return resPaperList;
    }

    private List<Paper> get10JudgeQuestion(String model) {
        List<Paper> paperList1 = paperMapper.getPaperByModelAndType(model, Constant.JudgeQuestion);
        List<Paper> resPaperList = new ArrayList<>();
        getRandomQuestion(5, paperList1, resPaperList);
        List<Paper> paperList2 = paperMapper.getPaperByModelAndType(Constant.Normal, Constant.JudgeQuestion);
        getRandomQuestion(5, paperList2, resPaperList);
        return resPaperList;
    }

    private List<Paper> get3SubjectiveQuestion(String model) {
        List<Paper> paperList1 = paperMapper.getPaperByModelAndType(model, Constant.SubjectiveQuestion);
        List<Paper> resPaperList = new ArrayList<>();
        getRandomQuestion(2, paperList1, resPaperList);
        List<Paper> paperList2 = paperMapper.getPaperByModelAndType(Constant.Normal, Constant.SubjectiveQuestion);
        getRandomQuestion(1, paperList2, resPaperList);
        return resPaperList;
    }

    private void getRandomQuestion(int size, List<Paper> paperList, List<Paper> resPaperList) {
        Map<Integer, Object> map = new HashMap<>();
        Random random = new Random(1000);
        for(int i = 0; i < size ; i++) {
            int index = random.nextInt(paperList.size()-1);
            if (map.containsKey(index)) {
                i--;
            }
            else {
                map.put(index, null);
                resPaperList.add(paperList.get(index));
            }
        }
    }
}
