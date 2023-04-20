package integrationTest;

import com.example.springbootdb1.configuration.SpringUnitTestBase;
import com.example.springbootdb1.controller.StudentController;
import com.example.springbootdb1.entity.Student;
import com.example.springbootdb1.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest extends SpringUnitTestBase {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void giveNameReturnStudents() throws Exception {

        Student alex = new Student("0001", "alex");

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(alex);

        given(studentService.listAllStudents()).willReturn(allStudents);

        mvc.perform(get("/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("alex"));
    }

}
