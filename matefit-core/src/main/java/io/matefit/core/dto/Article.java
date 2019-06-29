package io.matefit.core.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private int article_id;
    private String title;
    private String content;
    private int account_id;
    private Date created_at;
    private Date updated_at;
}
