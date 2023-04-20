package com.example.springbootdb1;

import com.example.springbootdb1.controller.StudentControllerTest;
import com.example.springbootdb1.repository.StudentRepositoryTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
        StudentControllerTest.class,
        StudentControllerTest.class,
        StudentRepositoryTest.class
})
class SpringBootDemo1ApplicationTests {

}
