package mybatisstudy;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.neuedu.pojo.TUser;

public class MyTest {
	@Test
	public void findUserById() throws IOException{
		//读取全局的配置文件（数据库链接）
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//建立连接工厂sqlSessionFactory
		SqlSessionFactory factory = builder.build(reader);
		SqlSession os = factory.openSession();
		TUser u = os.selectOne("tuser.findUserById", 3);
		System.out.println(u);
		os.close();
		
		//通过链接工厂获取sqlSession
		//执行数据库相关操作
		
	}
	@Test
	public void save() throws IOException{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//建立连接工厂sqlSessionFactory
		SqlSessionFactory factory = builder.build(reader);
//		SqlSession os = factory.openSession();
		SqlSession os = factory.openSession(true);
		TUser u = new TUser();
		u.setUserName("lxlxlx");
		u.setPassword("123");
		u.setUserSex("1");
		int res = os.insert("tuser.add", u);
		System.out.println(res);
		os.commit();//此处需要提交操作，否则不生效，但此步骤可以省略，方法是在factory.openSession()中添加参数true
		os.close();
		
	}
	@Test
	public void update() throws IOException{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//建立连接工厂sqlSessionFactory
		SqlSessionFactory factory = builder.build(reader);
//		SqlSession os = factory.openSession();
		SqlSession os = factory.openSession(true);
		TUser u = new TUser();
		u.setUserName("lxlxlx");
		u.setPassword("5555555");
		
		int res = os.insert("tuser.update", u);
		System.out.println(res);
		//os.commit();//此处需要提交操作，否则不生效，但此步骤可以省略，方法是在factory.openSession()中添加参数true
		os.close();
		
	}
	@Test
	public void delete() throws IOException{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//建立连接工厂sqlSessionFactory
		SqlSessionFactory factory = builder.build(reader);
//		SqlSession os = factory.openSession();
		SqlSession os = factory.openSession(true);
		TUser u = new TUser();
		u.setUserName("lxlxlx");
		int res = os.insert("tuser.delete", u);
		System.out.println(res);
		//os.commit();//此处需要提交操作，否则不生效，但此步骤可以省略，方法是在factory.openSession()中添加参数true
		os.close();
		
	}
	
}
