package io.matefit.api.service;

import io.matefit.api.response.DefaultRes;
import io.matefit.api.response.ResponseMessage;
import io.matefit.api.response.StatusCode;
import io.matefit.core.dto.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
@Transactional
public class CommentService {

    public DefaultRes createComment(@RequestBody Article article) {

        try{


            return DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS_TO_CREATE_ARTICLE);
        } catch (Exception e){

            return DefaultRes.res(StatusCode.OK, ResponseMessage.FAIL_TO_CREATE_ARTICLE);
        }

    }


}
