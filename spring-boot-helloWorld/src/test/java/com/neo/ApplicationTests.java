package com.neo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("测试类")
@SpringBootTest
public class ApplicationTests {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("@BeforeAll: 表示在所有单元测试之前执行");
	}
	
    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach: 表示在每个单元测试之前执行");
    }

	@Test
	public void contextLoads() {
		System.out.println("hello word");
	}
	
	@Test
	public void contextLoads2() {
		System.out.println("hello word2");
	}
}
