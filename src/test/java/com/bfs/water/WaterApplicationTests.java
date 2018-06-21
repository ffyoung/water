package com.bfs.water;

import com.bfs.entity.Water;
import com.bfs.mapper.UserMapper;
import com.bfs.mapper.WaterMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WaterApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private WaterMapper waterMapper;


	@Test
	public void contextLoads() {
		Water water = waterMapper.selectOne("0.001");
		System.out.println(water.toString());
	}
}
