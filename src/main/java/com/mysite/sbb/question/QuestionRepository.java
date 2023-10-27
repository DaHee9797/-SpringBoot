package com.mysite.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    // Question 리퍼토리지는 findBySubject와 같은 메서드를 제공하지 않음
    // findBySudject 메서드를 사용하려면 QuestionRepository 인터페이스를 변경해야 함
    Question findBySubject(String subject);

    // findBySubjectAndContent 메서드 또한 추가해야 함
    Question findBySubjectAndContent(String subject, String content);

    // findBySubjectLike 메서드 또한 추가해야 함
    List<Question> findBySubjectLike(String subject);
}
