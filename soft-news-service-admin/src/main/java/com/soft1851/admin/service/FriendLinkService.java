package com.soft1851.admin.service;

import com.soft1851.pojo.mo.FriendLinkMO;

import java.util.List;

/**
 * @author Su
 * @className FriendLinkService
 * @Description FriendLinkService接口
 * @Date 2020/11/24 11:25
 * @Version 1.0
 **/
public interface FriendLinkService {

    /**
     * 新增或者更新友情链接
     *
     * @param friendLinkMO 入参
     */
    void saveOrUpdateFriendLink(FriendLinkMO friendLinkMO);


    /**
     * 查询友情链接
     *
     * @return List<FriendLinkMO>
     */
    List<FriendLinkMO> queryAllFriendLinkList();

    /**
     * 删除友情列表
     *
     * @param linkId 链接id
     */
    void delete (String linkId);
}
