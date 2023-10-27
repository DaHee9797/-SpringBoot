package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;  // 답변 데이터 처리를 위해 답변 리포지터리가 필요
    @Transactional                              // AnswerRepository 객체를 @Autowired로 주입
    @Test
    void testJpa() {




    }
}






// 데이터 저장하기
// q1, q2 라는 Question 객체를 생성한다.
// QuestionRepository 를 이용하여 그 값을 데이터베이스에 저장하는 코드

//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);



// 데이터 조회하기  (findAll)
// question 테이블에 저장된 모든 데이터를 조회하기 위해 findAll메서드를 사용

//        List<Question> all = this.questionRepository.findAll();
//        assertEquals(2, all.size());
//
//        Question q = all.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());



// 데이터 조회하기  (findById)
// id 값으로 데이터를 조회하기 위해 findById 메서드를 사용

//        Optional<Question> oq = this.questionRepository.findById(1);
//
//        if (oq.isPresent()) {
//            Question q = oq.get();
//            assertEquals("sbb가 무엇인가요?", q.getSubject());



// 데이터 조회하기  (findBySubject)
// Question 엔티티의 subject 값으로 데이터 조회

//        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//        assertEquals(17, q.getId());



// 데이터 조회하기  (findbySubjctAndContent)
// 제목과 내용을 함께 조회

//        Question q = this.questionRepository.findBySubjectAndContent(
//                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//        assertEquals(17,q.getId());



// 데이터 조회하기  (findBySubjectLike)
// 제목에 특정 문자열이 포함되어 있는지를 조회
// sbb% -> sbb로 시작하는 문자열
// %sbb -> sbb로 끝나는 문자열
// %sbb% -> sbb를 포함하는 문자열



//        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//        Question q = qList.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());



// 데이터 수정하기
// 질문 데이터를 수정하는 코드를 작성

//        Optional<Question> oq = this.questionRepository.findById(17);
//        assertTrue(oq.isPresent());  // () 값이 true인지 테스트하는 것
//        Question q = oq.get();
//        q.setSubject("수정된 제목");
//        this.questionRepository.save(q);  // 변경된 Question 데이터를 저장하기 위헤 save 메서드를 사용



// 데이터 삭제하기

//        assertEquals(2, this.questionRepository.count());  // count 메서드는 리포지터리의 총 데이터건수를 리턴함
//        // 질문의 count(개수)가 2인지 비교해서 2가 아니면 에러가 남
//        Optional<Question> oq = this.questionRepository.findById(19); //id가 19번인 질문을 가져 옴
//        assertTrue(oq.isPresent());  // 가져온 oq가 존재하는지(빈값인지 아닌지) 체크해서 빈값이면 에러가 남
//        Question q = oq.get();  // oq에서 질문을 꺼내 옴
//        this.questionRepository.delete(q);  // 질문을 삭제함
//        assertEquals(1, this.questionRepository.count());  // 데이터가 2개에서 1개로 줄음
//        // 1하고 비교해서 맞으면 에러가 안나고 아니면 에러가 남



// 답변 데이터 생성 후 저장하기

//        Optional<Question> oq = this.questionRepository.findById(20);
//
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q);
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);



// 답변 조회하기

//        Optional<Answer> oa = this.answerRepository.findById(20);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(1, a.getQuestion().getId());



// 답변 연결된 질문 찾기 vs 질문에 달린 답변 찾기

//        Optional<Question> oq = this.questionRepository.findById(20);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        List<Answer> answerList = q.getAnswerList();
//
//        assertEquals(1, answerList.size());
//        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
