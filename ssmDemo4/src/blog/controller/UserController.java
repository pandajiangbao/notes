package blog.controller;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import javax.faces.flow.builder.ReturnBuilder;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import blog.entity.User;
import blog.service.UserService;
import blog.util.Md5Encrypt;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 登陆
	 * @param nameoremail
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("nameoremail") String nameoremail,
			@RequestParam("password") String password, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User user = userService.fingByUserLogin(nameoremail);
		if (user == null) {
			mav.setViewName("/error");
		} else {
			if (Md5Encrypt.getMD5(password).equals(user.getPassword())) {
				// mav.addObject("user",user);
				session.setAttribute("user", user);
				mav.setViewName("/signin");
			} else {
				System.out.println(Md5Encrypt.getMD5(password) + " " + user.getPassword());
				mav.setViewName("/error");
			}
		}

		return mav;
	}

	/**
	 * 注册
	 * @param username
	 * @param email
	 * @param pwd
	 * @param password_confirmation
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register(@RequestParam("username") String username, @RequestParam("email") String email,
			@RequestParam("pwd") String pwd, @RequestParam("password_confirmation") String password_confirmation) {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(pwd);
		user.setNickname(username);
		int res = userService.addUser(user);

		if (res != 0) {
			mav.addObject("user", user);
			mav.setViewName("/register_success");
		} else {
			mav.setViewName("/register_error");
		}

		return mav;

	}

	/**
	 * 显示个人信息
	 * @return
	 */
	@RequestMapping("/info")
	public ModelAndView info() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/userinfo");
		return mav;
	}

	/**
	 * 预修改信息
	 * @param session
	 * @return
	 */
	@RequestMapping("/preupdateinfo")
	public ModelAndView preupdate(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/preupdate");
		return mav;
	}

	/**
	 * 处理修改信息请求
	 * @param nickname
	 * @param email
	 * @param signature
	 * @param session
	 * @return
	 */
	@RequestMapping("/updateinfo")
	public ModelAndView updateinfo(@RequestParam("nickname") String nickname, @RequestParam("email") String email,
			@RequestParam("signature") String signature, HttpSession session) {
		User u = (User) session.getAttribute("user");
		u.setNickname(nickname);
		u.setEmail(email);
		u.setSignature(signature);
		session.setAttribute("user", u);
		userService.updateUser(u);
		String message="信息修改成功";
		ModelAndView mav = new ModelAndView();
		mav.addObject("message",message);
		mav.setViewName("redirect:/user/info");
		return mav;
	}
	/**
	 * 预修改密码
	 * @param session
	 * @return
	 */
	@RequestMapping("/prechangepw")
	public ModelAndView prechangepw(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/changepw");
		return mav;
	}
	/**
	 * 处理修改密码请求
	 * @param oldpw
	 * @param newpw
	 * @param session
	 * @return
	 */
	@RequestMapping("/changefinsh")
	public ModelAndView changepw(@RequestParam("oldpw") String oldpw, @RequestParam("newpw") String newpw,
			HttpSession session) {
		User u = (User) session.getAttribute("user");
		ModelAndView mav = new ModelAndView();
		if (Md5Encrypt.getMD5(oldpw).equals(u.getPassword())) {
			u.setPassword(Md5Encrypt.getMD5(newpw));
			session.setAttribute("user", u);
			userService.updateUser(u);
			String message="密码修改成功";
			mav.addObject("message",message);
			mav.setViewName("redirect:/user/info");
		} else {
			String message="密码修改失败，旧密码输入错误";
			mav.addObject("message",message);
			mav.setViewName("redirect:/user/info");
		}
		return mav;
	}
}
