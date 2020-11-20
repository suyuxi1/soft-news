package com.soft1851.enums;

/**
 * @Author su
 * @Date 2020/11/20
 * @Version 1.0
 */
public enum ArticleReviewLevel {
    PASS("pass", "自动审核通过"),
    BLOCK("block", "自动审核不通过"),
    REVIEW("review", "建议人工复审");
    public final String type;
    public final String value;
    ArticleReviewLevel(String type, String value) {
        this.type = type;
        this.value = value;
    }
}

