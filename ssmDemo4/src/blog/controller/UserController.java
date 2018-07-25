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
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("nameoremail") String nameoremail,@RequestParam("password") String password,HttpSession session){
		ModelAndView mav=new ModelAndView();
		User user = userService.fingByUserLogin(nameoremail);
		if (user==null){
			mav.setViewName("/error");
		}else{
			if(Md5Encrypt.getMD5(password).equals(user.getPassword())){
				
//				mav.addObject("user",user);
				session.setAttribute("user", user);
				mav.setViewName("/signin");
			}
			else{
				mav.setViewName("/error");
			}
		}
		
		return mav;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("pwd") String pwd,
			@RequestParam("password_confirmation") String password_confirmation){
		ModelAndView mav=new ModelAndView();
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(pwd);
		user.setNickname(username);
		int res = userService.addUser(user);
		
		if (res!=0){
			mav.addObject("user",user);
			mav.setViewName("/register_success");
		}else{
			mav.setViewName("/register_error");
		}
		
		return mav;
		
	}
	@RequestMapping("/info")
	public ModelAndView info(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/userinfo");
		return mav;
	}
	@RequestMapping("/updateinfo")
	public ModelAndView updateinfo(User user){
		userService.updateUser(user);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/updateuserinfo");
		return mav;
	}
}
