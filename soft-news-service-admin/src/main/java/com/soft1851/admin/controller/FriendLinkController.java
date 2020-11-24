package com.soft1851.admin.controller;

import com.soft1851.admin.service.FriendLinkService;
import com.soft1851.api.BaseController;
import com.soft1851.api.controller.admin.FriendLinkControllerApi;
import com.soft1851.pojo.bo.SaveFriendLinkBO;
import com.soft1851.pojo.mo.FriendLinkMO;
import com.soft1851.result.GraceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author su
 * @className FriendLinkController
 * @Description TODO
 * @Date 2020/11/24
 * @Version 1.0
 **/

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FriendLinkController extends BaseController implements FriendLinkControllerApi {

    private final FriendLinkService friendLinkService;

    @Override
    public GraceResult getFriendLinkList() {
        List<FriendLinkMO> list = friendLinkService.queryAllFriendLinkList();
        return GraceResult.ok(list);
    }

    @Override
    public GraceResult saveOrUpdateFriendLink(@Valid SaveFriendLinkBO saveFriendLinkB0, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> map = getErrors(result);
            return GraceResult.errorMap(map);
        }
        //将BO通过属性拷贝到MO
        FriendLinkMO saveFriendLinkMQ = new FriendLinkMO();
        BeanUtils.copyProperties(saveFriendLinkB0, saveFriendLinkMQ);
        saveFriendLinkMQ.setCreateTime(new Date());
        saveFriendLinkMQ.setUpdateTime(new Date());
        friendLinkService.saveOrUpdateFriendLink(saveFriendLinkMQ);
        return GraceResult.ok();
    }
}
