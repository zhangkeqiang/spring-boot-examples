package com.neo.repository;

import com.neo.model.User;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class UserRepositoryTests {

	@Resource
    private UserRepository userRepository;

	@Test
	public void testBaseQuery() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		User user=new User("ff8", "ff123456","ff8@127.com", "ff8",  formattedDate);
//		userRepository.findAll();
//		userRepository.findById(3L);
		userRepository.save(user);
//		user.setId(2L);
//		userRepository.delete(user);
//		userRepository.count();
//		userRepository.existsById(3L);
	}
	
	@Test
	public void testSave() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		userRepository.save(new User("aa8", "aa123456","aa8@127.com", "aa8",  formattedDate));
		userRepository.save(new User("bb8", "bb123456","bb8@127.com", "bb8",  formattedDate));
		userRepository.save(new User("cc8", "cc123456","cc8@127.com", "cc8",  formattedDate));

		assertEquals(10, userRepository.findAll().size());
		assertEquals("bb8", userRepository.findByUserNameOrEmail("bb8", "bb8@126.com").getNickName());
		assertEquals("aa8", userRepository.findByUserName("aa8").getNickName());
	}




//	@Test
//	public void testCustomSql() {
//		userRepository.modifyById("neo",3L);
//		userRepository.deleteById(3L);
//		userRepository.findByEmail("ff@126.com");
//	}


	@Test
	public void testPageQuery()  {
//		int page=1,size=2;
//		Sort sort = new Sort(Sort.Direction.DESC, "id");
//		Pageable pageable = PageRequest.of(page, size, sort);
//		userRepository.findALL(pageable);
//		userRepository.findByNickName("aa", pageable);
	}

	@Test
	public void ztearDown() {
		userRepository.delete(userRepository.findByUserName("aa8"));
		userRepository.delete(userRepository.findByUserName("bb8"));
		userRepository.delete(userRepository.findByUserName("cc8"));
		userRepository.delete(userRepository.findByUserName("ff8"));
	}
}