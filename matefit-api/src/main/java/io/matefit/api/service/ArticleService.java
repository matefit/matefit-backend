package io.matefit.api.service;

import io.matefit.api.response.DefaultRes;
import io.matefit.api.response.ResponseMessage;
import io.matefit.api.response.StatusCode;
import io.matefit.core.domain.Article;
import io.matefit.core.dto.ArticleDto;
import io.matefit.core.dto.HashtagDto;
import io.matefit.core.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public DefaultRes createArticle(final @RequestBody ArticleDto articleDto) {

        try {
            String content = articleDto.getContent();
            char makeNamePublic = articleDto.getMakeNamePublic();
            char makeBirthdayPublic = articleDto.getMakeBirthdayPublic();
            Date makeArticlePublicUntil = articleDto.getMakeArticlePublicUntil();
            Long account_id = new Long(articleDto.getAccount_id());

            Article article = Article.builder()
                                     .content(content)
                                     .makeNamePublic(makeNamePublic)
                                     .makeBirthdayPublic(makeBirthdayPublic)
                                     .makeArticlePublicUntil(makeArticlePublicUntil)
                                     .account_id(account_id)
                                     .build();

            articleRepository.save(article);
            return DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS_TO_CREATE_ARTICLE);

        } catch (Exception e) {
            return DefaultRes.res(StatusCode.OK, ResponseMessage.FAIL_TO_CREATE_ARTICLE);
        }

    }

    public DefaultRes searchArticle(final @RequestParam List<Character> HashtagList,
                                    final @RequestParam String location,
                                    final @RequestParam char sex,
                                    final @RequestParam char roomType) {
        try {
            char smoking = HashtagList.get(0);
            char pet = HashtagList.get(1);
            char job = HashtagList.get(2);
            char student = HashtagList.get(3);
            char snoring = HashtagList.get(4);
            char morning = HashtagList.get(5);
            char night = HashtagList.get(6);
            char nightEating = HashtagList.get(7);
            char quiet = HashtagList.get(8);
            char social = HashtagList.get(9);

            // H2 조회
            // 0. location, sex, roomType에 맞는 유저들을 1차로 필터링 할 것
            // 1. 각 유저 uuid를 FK로 Hashtag 테이블 조회
            // 2. 각 Hashtag 비교 후 일치하는 태그 갯수 저장
            // 3. <uuid, [O, X, O, O, ...]> 의 형태로 Map에 저장
            // 4. 위 작업이 마무리 되면 해당 Map을 프론트에 전달

            return DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS_TO_DELETE_ARTICLE);
        } catch (Exception e) {
            return DefaultRes.res(StatusCode.OK, ResponseMessage.FAIL_TO_DELETE_ARTICLE);
        }

    }

    public DefaultRes filterArticle(final @RequestBody ArticleDto articleDto) {

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
//            return DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS_TO_DELETE_ARTICLE);
//        } catch (Exception e) {
//            return DefaultRes.res(StatusCode.OK, ResponseMessage.FAIL_TO_DELETE_ARTICLE);
//        }
//
//    }

}
