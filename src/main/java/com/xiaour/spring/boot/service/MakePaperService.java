package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.Question;

import java.util.List;

public interface MakePaperService {

    List<Question> getPaper(int model);

}
