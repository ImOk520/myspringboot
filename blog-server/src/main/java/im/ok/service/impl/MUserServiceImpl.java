package im.ok.service.impl;

import im.ok.entity.MUser;
import im.ok.mapper.MUserMapper;
import im.ok.service.IMUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author imok
 * @since 2021-04-14
 */
@Service
public class MUserServiceImpl extends ServiceImpl<MUserMapper, MUser> implements IMUserService {

}
