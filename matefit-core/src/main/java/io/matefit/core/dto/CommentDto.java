package io.matefit.core.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {
    private int comment_id;
    private String content;
    private int account_id;
    private int article_id;
    private Date created_at;
    private Date updated_at;

}
