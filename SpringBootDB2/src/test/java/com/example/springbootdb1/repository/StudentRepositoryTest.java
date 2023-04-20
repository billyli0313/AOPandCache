package com.example.springbootdb1.repository;

import com.example.springbootdb1.SpringBootDB2;
import com.example.springbootdb1.configuration.SpringUnitTestBase;
import com.example.springbootdb1.entity.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {

    /*
    * @DataJPAtest
    * Spring Boot provides a convenient way to set up an environment with an embedded database to test our database queries against.
    * */

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private JPAStudentRepository studentRepository;

    @Before
    public void setup() {
        entityManager.clear();
    }


    @Test
    public void whenFindById_thenReturnStudent() {
        // given
        Student student = new Student("000299","alex");
        Student alex = new Student();
        studentRepository.save(student);

        // when
        Optional<Student> result = studentRepository.findById("000299");
        if (result.isPresent()) {
            alex = (Student) result.get();
        }

        // then
        assertThat(alex.getName()).isEqualTo("alex");
    }

    /*
    * However, TestEntityManager is to directly connect to real database
     */

    @Test
    public void listStudentbyIdTest_withEntityManager() {
        Student student = new Student("000111111","alex");
        entityManager.persist(student);
        entityManager.flush();

        Optional<Student> result = studentRepository.findById("000111111");
        Student studentRes = result.get();
        assertThat(studentRes.getName()).isEqualTo("alex");
    }
}
