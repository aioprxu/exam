package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.Paper;

import java.util.List;

public interface PaperMapper {
    boolean addPaper(Paper paper);
    boolean delPaper(int id);
    boolean updatePaper(Paper paper);
    List<Paper> queryAllPaper();
    List<Paper> queryPaperByModel(int model);
    Paper queryPaperById(int id);
}
