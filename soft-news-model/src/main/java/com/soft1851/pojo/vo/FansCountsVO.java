package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author su
 * @className FansCountsVo
 * @Description TODO
 * @Date 2020/11/26
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FansCountsVO {

    private Integer manCounts;
    private Integer womanCounts;
}
