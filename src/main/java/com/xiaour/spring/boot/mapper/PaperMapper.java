package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.Paper;

import java.util.List;

public interface PaperMapper {

    Paper paperList();

    List<Paper> getPaperByType(String type);

    List<Paper> getPaperByModel(String model);

    List<Paper> getPaperByModelAndType(String model, String type);

}
