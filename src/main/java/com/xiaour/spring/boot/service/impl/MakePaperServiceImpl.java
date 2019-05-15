package com.xiaour.spring.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.constant.Constant;
import com.xiaour.spring.boot.entity.Paper;
import com.xiaour.spring.boot.entity.Question;
import com.xiaour.spring.boot.mapper.QuestionMapper;
import com.xiaour.spring.boot.service.MakePaperService;
import com.xiaour.spring.boot.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
//组卷策略，选择题4道，1道通用，1道专有，共40分，判断1道，共10分，填空2道，20分，主观1道，30分
public class MakePaperServiceImpl implements MakePaperService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getPaper(int model) {
        List<Question> paperList = new ArrayList<>();
        paperList.addAll(getChoiceQuestion(model));
        paperList.addAll(getFillBlankQuestion(model));
        paperList.addAll(getJudgeQuestion(model));
        paperList.addAll(getSubjectiveQuestion(model));
        return paperList;
    }

    private List<Question> getChoiceQuestion(int model) {
        List<Question> paperList1 = questionMapper.getQuestionByModelAndType(model, Constant.ChoiceQuestion);
        System.out.println(JSON.toJSONString(paperList1));
        List<Question> resPaperList = new ArrayList<>();
        getRandomQuestion(2, paperList1, resPaperList);
        List<Question> paperList2 = questionMapper.getQuestionByModelAndType(Constant.Normal, Constant.ChoiceQuestion);
        getRandomQuestion(2, paperList2, resPaperList);
        return resPaperList;
    }

    private List<Question> getFillBlankQuestion(int model) {
        List<Question> paperList1 = questionMapper.getQuestionByModelAndType(model, Constant.FillBlankQuestion);
        List<Question> resPaperList = new ArrayList<>();
        getRandomQuestion(2, paperList1, resPaperList);
        List<Question> paperList2 = questionMapper.getQuestionByModelAndType(Constant.Normal, Constant.FillBlankQuestion);
        getRandomQuestion(1, paperList2, resPaperList);
        return resPaperList;
    }

    private List<Question> getJudgeQuestion(int model) {
        List<Question> paperList1 = questionMapper.getQuestionByModelAndType(model, Constant.JudgeQuestion);
        List<Question> resPaperList = new ArrayList<>();
        getRandomQuestion(1, paperList1, resPaperList);
        List<Question> paperList2 = questionMapper.getQuestionByModelAndType(Constant.Normal, Constant.JudgeQuestion);
        getRandomQuestion(1, paperList2, resPaperList);
        return resPaperList;
    }

    private List<Question> getSubjectiveQuestion(int model) {
        List<Question> paperList1 = questionMapper.getQuestionByModelAndType(model, Constant.SubjectiveQuestion);
        List<Question> resPaperList = new ArrayList<>();
        getRandomQuestion(1, paperList1, resPaperList);
        List<Question> paperList2 = questionMapper.getQuestionByModelAndType(Constant.Normal, Constant.SubjectiveQuestion);
        getRandomQuestion(1, paperList2, resPaperList);
        return resPaperList;
    }

    private void getRandomQuestion(int size, List<Question> paperList, List<Question> resPaperList) {
        Map<Integer, Object> map = new HashMap<>();
        Random random = new Random(1000);
        for(int i = 0; i < size && i < paperList.size(); i++) {
            int index = random.nextInt(paperList.size());
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
