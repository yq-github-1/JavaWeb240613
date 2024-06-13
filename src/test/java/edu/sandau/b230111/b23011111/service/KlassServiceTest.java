package edu.sandau.b230111.b23011111.service;

import edu.sandau.b230111.b23011111.entity.Klass;
import edu.sandau.b230111.b23011111.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KlassServiceTest {

    @Autowired
    private KlassService klassService;

    @Test
    void findAll() {
        List<Klass> klasses = klassService.findAll(new Klass());
        Assertions.assertNotNull(klasses);
        Assertions.assertNotEquals(0,klasses.size());
    }

    @Test
    void getReferenceById() {
        Klass klass = klassService.getReferenceById(1);
        Assertions.assertNotNull(klass);
    }
}