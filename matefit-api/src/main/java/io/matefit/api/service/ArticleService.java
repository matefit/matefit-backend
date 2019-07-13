package io.matefit.api.service;

import io.matefit.api.response.DefaultRes;
import io.matefit.api.response.ResponseMessage;
import io.matefit.api.response.StatusCode;
import io.matefit.core.domain.Article;
import io.matefit.core.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
@Transactional
public class ArticleService {

    public DefaultRes createArticle(@RequestBody ArticleDto articleDto) {

        try {

            return DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS_TO_CREATE_ARTICLE);

        } catch (Exception e) {

            return DefaultRes.res(StatusCode.OK, ResponseMessage.FAIL_TO_CREATE_ARTICLE);
        }

    }

    public DefaultRes searchArticle(@RequestBody ArticleDto articleDto) {

        try {
            // dto -> entity

            return DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS_TO_DELETE_ARTICLE);
        } catch (Exception e) {

            return DefaultRes.res(StatusCode.OK, ResponseMessage.FAIL_TO_DELETE_ARTICLE);
        }

    }

    public DefaultRes filterArticle(@RequestBody ArticleDto articleDto) {

        try {
            // dto -> entity

            return DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS_TO_DELETE_ARTICLE);
        } catch (Exception e) {

            return DefaultRes.res(StatusCode.OK, ResponseMessage.FAIL_TO_DELETE_ARTICLE);
        }

    }


//    public DefaultRes deleteArticle(@RequestBody ArticleDto articleDto) {
//
//        try {
//            // dto -> entity
//
//            return DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS_TO_DELETE_ARTICLE);
//        } catch (Exception e) {
//
//            return DefaultRes.res(StatusCode.OK, ResponseMessage.FAIL_TO_DELETE_ARTICLE);
//        }
//
//    }

}
