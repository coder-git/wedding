package com.tx.demo;

import com.tx.demo.common.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RedisUtil redisUtil;

	@Test
	void contextLoads() {
		boolean flag = redisUtil.set("12","12");
		System.out.println(flag);
	}

}
