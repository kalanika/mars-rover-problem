package com.texus.marsrover;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarsroverApplication.class)
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class MarsroverApplicationTests {

/*	@Test
	public void contextLoads() {
	}*/

}
