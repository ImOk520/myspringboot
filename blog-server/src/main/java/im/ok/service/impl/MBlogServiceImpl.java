package im.ok.service.impl;

import im.ok.entity.MBlog;
import im.ok.mapper.MBlogMapper;
import im.ok.service.IMBlogService;
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
public class MBlogServiceImpl extends ServiceImpl<MBlogMapper, MBlog> implements IMBlogService {

}
