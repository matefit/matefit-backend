package io.matefit.core.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DoubleComment {
    private int double_comment_id;
    private String content;
    private int account_id;
    private int comment_id;
    private Date created_at;
    private Date updated_at;
}
