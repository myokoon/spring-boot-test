package com.emyang.bootpjt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:/test.properties")
public class BootpjtApplicationTests {
	
	@Autowired
	Environment environment;
	
	@Test
	public void contextLoads() {
		System.out.println(environment.getProperty("emyang.name"));
		assertThat(environment.getProperty("emyang.name")).isEqualTo("test");
	}

}
