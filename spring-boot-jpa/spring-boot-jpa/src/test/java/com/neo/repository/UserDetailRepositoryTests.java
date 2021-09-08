package com.neo.repository;

import com.neo.model.Address;
import com.neo.model.User;
import com.neo.model.UserDetail;
import com.neo.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailRepositoryTests {

	@Resource
	private AddressRepository addressRepository;
	@Resource
	private UserDetailRepository userDetailRepository;

	@Test
	public void testSaveAddress() {
		Address address=new Address();
		address.setUserId(1L);
		address.setCity("北京");
		address.setProvince("北京");
		address.setStreet("分钟寺");
//		addressRepository.save(address);
	}

	@Test
	public void testSaveUserDetail() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		UserDetail userDetail=new UserDetail();
		userDetail.setUserId(3L);
		userDetail.setHobby("吃鸡游戏");
		userDetail.setAge(28);
		userDetail.setIntroduction("一个爱玩的人");
//		userDetailRepository.save(userDetail);
	}

	@Test
	public void testUserInfo()  {
		System.out.println("testUserInfo");
		List<UserInfo> userInfos=userDetailRepository.findUserInfo("吃鸡游戏");
		for (UserInfo userInfo:userInfos){
			System.out.println("userInfo: "+userInfo.getUserName()+"-"+userInfo.getEmail()+"-"+userInfo.getHobby()+"-"+userInfo.getIntroduction());
		}
		
		UserDetail userDetail = userDetailRepository.findByHobby("吃鸡游戏");
		assertEquals(3,userDetail.getUserId());
	}
}