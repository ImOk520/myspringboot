package feng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2020/9/10 9:06
 */
@Mapper
@Repository
public interface DataInitDao {

    int update();
}
