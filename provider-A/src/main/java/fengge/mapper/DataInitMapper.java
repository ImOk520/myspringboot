package fengge.mapper;

import fengge.DTO.DataEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yechao
 * @date 2020/9/10 9:06
 */
@Repository
public interface DataInitMapper {

    /**
     * 根据id查询对应数据
     * @param duid
     * @return
     */
    String selectData( @Param("duid") String duid);

    List<String> selectMedicalList(@Param("queryString") String queryString);

    int add( @Param("item") DataEntity item);
}
