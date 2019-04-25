package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperMapper {

    Paper paperList();

    List<Paper> getPaperByType(String type);

    List<Paper> getPaperByModel(int model);

    List<Paper> getPaperByModelAndType(@Param("model") int model, @Param("type") String type);

}
