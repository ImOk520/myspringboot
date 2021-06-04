package feng.mapper;

import feng.entity.DeptBak;
import feng.entity.DeptBakExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptBakMapper {
    long countByExample(DeptBakExample example);

    int deleteByExample(DeptBakExample example);

    int deleteByPrimaryKey(Long deptno);

    int insert(DeptBak record);

    int insertSelective(DeptBak record);

    List<DeptBak> selectByExample(DeptBakExample example);

    DeptBak selectByPrimaryKey(Long deptno);

    int updateByExampleSelective(@Param("record") DeptBak record, @Param("example") DeptBakExample example);

    int updateByExample(@Param("record") DeptBak record, @Param("example") DeptBakExample example);

    int updateByPrimaryKeySelective(DeptBak record);

    int updateByPrimaryKey(DeptBak record);
}