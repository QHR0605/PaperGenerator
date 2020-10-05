package Test1;

import java.util.Map.Entry; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssf.controller.RegesterController;
import com.ssf.service.QuesServiceImpl;
import com.ssf.util.constant.Constant;
import com.ssf.util.json.JsonResult;
import com.ssf.util.json.QuesAndAnswersJson;

public class Test01 {
	
	
	ClassPathXmlApplicationContext context ; 
	ClassPathXmlApplicationContext context2;
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		context2 = new ClassPathXmlApplicationContext("spring/Spring-MVC.xml");
	}
	
	@After
	public void destroy() {
		context.close();
	}
	
	@Test
	
	public void testService() throws Exception {
		
		
		
		QuesServiceImpl serviceImpl = context.getBean("quesServiceImpl", QuesServiceImpl.class);
		
		QuesAndAnswersJson jsonResult =  serviceImpl.MakeQues("小学", "10");
		
		for (Entry<Integer, String> entry : jsonResult.getM_quesAndanswers().entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		context.close();
	}
	
	@Test
	
	public void testSpringMVC() {
		
		RegesterController controller = context2.getBean("regesterController",RegesterController.class);
		
		controller.reg();
		
	}
}
