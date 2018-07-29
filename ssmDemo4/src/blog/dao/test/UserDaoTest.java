package blog.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import blog.dao.UserDao;
import blog.entity.User;
<<<<<<< HEAD
import blog.util.Md5Encrypt;
=======
>>>>>>> upstream/master

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class UserDaoTest {
	
	@Resource
	private UserDao userDao;
	
<<<<<<< HEAD
	@Test
	public void addUser() throws Exception{
		User user = new User();
		user.setUsername("zzz");
		user.setEmail("123@qq.com");
		user.setPassword(Md5Encrypt.getMD5("123"));
		user.setNickname("pandagege");
		user.setProfile("${pageContext.request.contextPath}/images/head/aaa.jpg");
		//User u = new User("ronething","123456","axing","178965100@qq.com","è¿™æ˜¯ä¸€ä¸ªä¸ªæ€§ç­¾å","images/touxiang",1);
		Integer res = userDao.addUser(user);
		System.out.println(res);
	}
=======
//	@Test
//	public void addUser() throws Exception{
//		User u = new User("ronething","123456","axing","178965100@qq.com","ÕâÊÇÒ»¸ö¸öÐÔÇ©Ãû","images/touxiang",1);
//		Integer res = userDao.addUser(u);
//		System.out.println(res);
//	}
>>>>>>> upstream/master
	
//	@Test
//	public void updateUser() throws Exception{
//		User user = new User();
//		user.setId(3);
//		user.setUsername("demo");
//		user.setPassword("12345678");
//		user.setEmail("axingfly@gmail.com");
<<<<<<< HEAD
//		user.setSignature("è¿™æ˜¯ä¸€ä¸ªæµ‹è¯•");
//		user.setProfile("è¿™æ˜¯ä¸€ä¸ªprofile");
=======
//		user.setSignature("ÕâÊÇÒ»¸ö²âÊÔ");
//		user.setProfile("ÕâÊÇÒ»¸öprofile");
>>>>>>> upstream/master
//		user.setRole(0);
//		int res = userDao.updateUser(user);
//		System.out.println(res);
//	}
	
//	@Test
//	public void findById() throws Exception{
//		User user = userDao.findById(3);
//		System.out.println(user);
//	}
<<<<<<< HEAD
//	@Test
//	public void listUser() throws Exception{
//		List<User> users = userDao.listUser();
//		for (User user : users) {
//			System.out.println(user);
//		}
//	}
//	@Test
//	public void fingByUserLogin() throws Exception{
//		User user = userDao.fingByUserLogin("demo");
//		System.out.println(user.getPassword());
//	}
=======
	
	@Test
	public void listUser() throws Exception{
		List<User> users = userDao.listUser();
		for (User user : users) {
			System.out.println(user);
		}
	}
>>>>>>> upstream/master
}
