package test.hibernate;

import java.io.File;





import org.apache.log4j.PropertyConfigurator;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.Log4jConfigListener;


public class TestHibernate {
	private static Configuration cfg=null;
	private static SessionFactory factory=null;
	private static final Logger log=LoggerFactory.getLogger(TestHibernate.class);
	static{
		PropertyConfigurator.configure(TestHibernate.class.getClassLoader().getResource("").getFile()+File.separatorChar+"cfg"+File.separatorChar+"log4j.properties");
		cfg=new Configuration().configure("/test/cfg/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
	}
	@Test
	public void TestCofig(){
		log.info("teste");
	}
}
