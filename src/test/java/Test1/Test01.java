package Test1;

import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssf.service.QuesServiceImpl;
import com.ssf.util.json.JsonResult;
import com.ssf.util.json.QuesAndAnswersJson;

public class Test01 {
		
	@Test
	
	public void testService() throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		QuesServiceImpl serviceImpl = context.getBean("quesServiceImpl", QuesServiceImpl.class);
		
		QuesAndAnswersJson jsonResult =  serviceImpl.MakeQues(2, 10);
		
		for (Entry<String, String> entry : jsonResult.getM_quesAndanswers().entrySet()) {
			System.out.println(entry.getKey());
		}
	}
}
