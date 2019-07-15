package io.matefit.core.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleDto {
    private int article_id;
    private String content;
    private char makeNamePublic;
    private char makeBirthdayPublic;
    private Date makeArticlePublicUntil;
    private int account_id;
    private Date created_at;
    private Date updated_at;
}
