package com.soft1851.admin.service.impl;

import com.soft1851.admin.repository.FriendLinkRepository;
import com.soft1851.admin.service.FriendLinkService;
import com.soft1851.pojo.mo.FriendLinkMO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author su
 * @className FriendLinkServiceImpl
 * @Description TODO
 * @Date 2020/11/24
 * @Version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FriendLinkServiceImpl implements FriendLinkService {

    private final FriendLinkRepository friendLinkRepository;

    @Override
    public void saveOrUpdateFriendLink(FriendLinkMO friendLinkMO) {
        friendLinkRepository.save(friendLinkMO);
    }


    @Override
    public List<FriendLinkMO> queryAllFriendLinkList() {
        return friendLinkRepository.findAll();
    }

    @Override
    public void delete(String linkId) {
        friendLinkRepository.deleteById(linkId);
    }
}
