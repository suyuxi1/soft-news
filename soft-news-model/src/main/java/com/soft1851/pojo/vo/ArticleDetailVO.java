package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author su
 * @className ArticleDetailVO
 * @Description TODO
 * @Date 2020/11/26
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDetailVO {
    private String id;
    private String title;
    private String cover;
    private Integer categoryId;
    private String categoryName;
    private String publishUserId;
    private Date publishTime;
    private String content;
    private String publishUserName;
    private Integer readCounts;
}
