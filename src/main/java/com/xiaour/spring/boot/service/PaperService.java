package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.Paper;
import com.xiaour.spring.boot.entity.Question;
import com.xiaour.spring.boot.request.AddPaperReq;
import com.xiaour.spring.boot.request.PaperReq;

import java.util.List;

public interface PaperService {
    boolean addPaper(AddPaperReq paper);
    boolean delPaper(int paperId);
    boolean updatePaper(PaperReq paper);
    List<Paper> getPaperByModel(int modelId);
    List<Paper> getAllPaper();
    List<Question> getFile(int examId);
}
