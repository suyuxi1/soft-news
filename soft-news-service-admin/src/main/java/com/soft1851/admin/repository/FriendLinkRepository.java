package com.soft1851.admin.repository;

import com.soft1851.pojo.mo.FriendLinkMO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Su
 * @className FriendLinkRepository
 * @Description 友链操作
 * @Date 2020/11/24 11:22
 * @Version 1.0
 **/
public interface FriendLinkRepository extends MongoRepository<FriendLinkMO, String> {

    List<FriendLinkMO> getAllByIsDelete(Integer isDelete);
}
