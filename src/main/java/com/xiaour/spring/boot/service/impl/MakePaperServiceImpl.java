package com.xiaour.spring.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.constant.Constant;
import com.xiaour.spring.boot.entity.Paper;
import com.xiaour.spring.boot.entity.Question;
import com.xiaour.spring.boot.mapper.QuestionMapper;
import com.xiaour.spring.boot.service.MakePaperService;
import com.xiaour.spring.boot.service.ZookeeperService;
import com.xiaour.spring.boot.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
//组卷策略，选择题4道，1道通用，1道专有，共40分，判断1道，共10分，填空2道，20分，主观1道，30分
public class MakePaperServiceImpl implements MakePaperService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private ZookeeperService zookeeperService;

    @Override
    public List<Question> getPaper(int model) {
        String config = zookeeperService.getConfig();
        int [] configs = {2,2,2,1,1,1,1,1};
        List<Question> paperList = new ArrayList<>();
        if (config != null) {
            String [] c = config.split(",");
            paperList.addAll(getChoiceQuestion(model,Integer.parseInt(c[0]),Integer.parseInt(c[1])));
            paperList.addAll(getFillBlankQuestion(model,Integer.parseInt(c[2]),Integer.parseInt(c[3])));
            paperList.addAll(getJudgeQuestion(model,Integer.parseInt(c[4]),Integer.parseInt(c[5])));
            paperList.addAll(getSubjectiveQuestion(model,Integer.parseInt(c[6]),Integer.parseInt(c[7])));
        } else {
            paperList.addAll(getChoiceQuestion(model,configs[0],configs[1]));
            paperList.addAll(getFillBlankQuestion(model,configs[2],configs[3]));
            paperList.addAll(getJudgeQuestion(model,configs[4],configs[5]));
            paperList.addAll(getSubjectiveQuestion(model,configs[6],configs[7]));
        }
        return paperList;
    }

    private List<Question> getChoiceQuestion(int model, int a, int b) {
        List<Question> paperList1 = questionMapper.getQuestionByModelAndType(model, Constant.ChoiceQuestion);
        System.out.println(JSON.toJSONString(paperList1));
        List<Question> resPaperList = new ArrayList<>();
        getRandomQuestion(a, paperList1, resPaperList);
        List<Question> paperList2 = questionMapper.getQuestionByModelAndType(Constant.Normal, Constant.ChoiceQuestion);
        getRandomQuestion(b, paperList2, resPaperList);
        return resPaperList;
    }

    private List<Question> getFillBlankQuestion(int model, int a, int b) {
        List<Question> paperList1 = questionMapper.getQuestionByModelAndType(model, Constant.FillBlankQuestion);
        List<Question> resPaperList = new ArrayList<>();
        getRandomQuestion(a, paperList1, resPaperList);
        List<Question> paperList2 = questionMapper.getQuestionByModelAndType(Constant.Normal, Constant.FillBlankQuestion);
        getRandomQuestion(b, paperList2, resPaperList);
        return resPaperList;
    }

    private List<Question> getJudgeQuestion(int model, int a, int b) {
        List<Question> paperList1 = questionMapper.getQuestionByModelAndType(model, Constant.JudgeQuestion);
        List<Question> resPaperList = new ArrayList<>();
        getRandomQuestion(a, paperList1, resPaperList);
        List<Question> paperList2 = questionMapper.getQuestionByModelAndType(Constant.Normal, Constant.JudgeQuestion);
        getRandomQuestion(b, paperList2, resPaperList);
        return resPaperList;
    }

    private List<Question> getSubjectiveQuestion(int model, int a, int b) {
        List<Question> paperList1 = questionMapper.getQuestionByModelAndType(model, Constant.SubjectiveQuestion);
        List<Question> resPaperList = new ArrayList<>();
        getRandomQuestion(a, paperList1, resPaperList);
        List<Question> paperList2 = questionMapper.getQuestionByModelAndType(Constant.Normal, Constant.SubjectiveQuestion);
        getRandomQuestion(b, paperList2, resPaperList);
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
