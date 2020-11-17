package com.soft1851.user.service.impl;

import com.soft1851.enums.UserStatus;
import com.soft1851.exception.GraceException;
import com.soft1851.pojo.AppUser;
import com.soft1851.pojo.bo.UpdateUserInfoBO;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.user.mapper.AppUserMapper;
import com.soft1851.user.service.UserService;
import com.soft1851.utils.DateUtil;
import com.soft1851.utils.DesensitizationUtil;
import com.soft1851.utils.RedisOperator;
import lombok.RequiredArgsConstructor;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author su
 * @className UserServiceImpl
 * @Description TODO
 * @Date 2020/11/16
 * @Version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    public final AppUserMapper appUserMapper;
    public final RedisOperator redis;

    @Resource
    private Sid sid;

    public static final String REDIS_USER_INFO = "redis_user_info";

    public static final String USER_FACE0 = "https://yuxis.oss-cn-beijing.aliyuncs.com/audio-book/face/face.jpg";

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void UpdateUserInfo(UpdateUserInfoBO updateUserInfoBO) {
        AppUser userInfo = AppUser.builder().build();
        BeanUtils.copyProperties(updateUserInfoBO, userInfo);

        userInfo.setUpdatedTime(new Date());
        userInfo.setActiveStatus(UserStatus.Active.type);

        int result = appUserMapper.updateByPrimaryKeySelective(userInfo);
        if (result != 1){
            GraceException.display(ResponseStatusEnum.USER_UPDATE_ERROR);
        }
    }

    @Override
    public AppUser getUser(String userId) {
        return appUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public AppUser queryMobileIsExist(String mobile) {
        Example userExample = new Example(AppUser.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("mobile", mobile);
        return appUserMapper.selectOneByExample(userExample);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AppUser createUser(String mobile) {
        //若分库分表，数据库表主键id必须保证全局唯一，不得重复
        String userId = sid.nextShort();
        //构建用户对象
        AppUser user = AppUser.builder()
                .id(userId)
                .mobile(mobile)
                .nickname("用户:" + DesensitizationUtil.commonDisplay(mobile) )
                .face(USER_FACE0)
                .birthday(DateUtil.stringToDate("2000-01-01"))
                .activeStatus(UserStatus.INACTIVE.type)
                .totalIncome(0)
                .createdTime(new Date())
                .updatedTime(new Date())
                .build();
        //执行插入方法
        appUserMapper.insert(user);
        return user;
    }
}