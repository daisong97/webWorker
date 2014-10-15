package test.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dais.domain.User;
import com.dais.service.UserService;

public class TestSpring {
	private static ApplicationContext context=null;
	static{
		context=new ClassPathXmlApplicationContext("classpath:cfg/applicationContext.xml");
	}
	//@Autowired BaseDao<User> baseDao;
	@Test
	public void testSpring(){
		UserService ui=(UserService) context.getBean("userService");
		User u=ui.find(new Integer(2));
		System.out.println(u.getName());
	}
	public static void main(String[] args) {
		UserService ui= (UserService)context.getBean("userService");
	}
}
