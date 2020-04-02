package spring.test.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import spring.test.example.model.User;
import spring.test.example.repository.UserRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void findById(){
        int id = 1;
        User user = User
                .builder()
                .name("Tomas")
                .email("tomas@gmail.com")
                .password("abcd")
                .build();
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        Optional<User> actualUser = userService.findById(id);
        assertTrue(actualUser.isPresent());
        assertEquals(user.getName(),actualUser.get().getName());
    }

}
