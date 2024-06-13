package edu.sandau.b230111.b23011111.repository;

import edu.sandau.b230111.b23011111.entity.User;
import edu.sandau.b230111.b23011111.respository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByName(){
        List<User> users = userRepository.findByName("杨倩");
        Assertions.assertNotNull(users);
        Assertions.assertEquals(1,users.size());
    }

    @Test
    void findAll(){
        List<User> users = userRepository.findAll();
        Assertions.assertNotNull(users);
        Assertions.assertNotEquals(0,users.size());
    }
}
