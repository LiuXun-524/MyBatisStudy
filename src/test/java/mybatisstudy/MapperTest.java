package mybatisstudy;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.dao.mapper.DeptMapper;
import com.neuedu.dao.mapper.TUserMapper;
import com.neuedu.dao.mapper.TWifeMapper;
import com.neuedu.pojo.Dept;
import com.neuedu.pojo.TUser;
import com.neuedu.pojo.Wife;

public class MapperTest {
	SqlSessionFactory factory = null;
	SqlSession session = null;
	//有四行重复代码，利用junit中的before注解
	@Before
	public void init() throws IOException{
		String resource = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//建立连接工厂sqlSessionFactory
		factory = builder.build(reader);
		session = factory.openSession(true);
		System.out.println("junit初始化被调用");
	}
	
	@After
	public void closeConn(){
		session.close();
		System.out.println("junit收尾被调用");
	}
	
	@Test
	public void findUserById() throws IOException{
		//通过xml配置的方式执行sql语句
		//读取全局的配置文件（数据库链接）
		
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		TUser user = mapper.findUserById(3);
		System.out.println(user.toString());
		
		//通过链接工厂获取sqlSession
		//执行数据库相关操作
		
	}
	@Test
	public void findAll() throws IOException{
		//通过注解方式执行sql语句
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		List<TUser> allUser = mapper.findAllUser();
		for (Iterator<TUser> iterator = allUser.iterator(); iterator.hasNext();) {
			TUser tUser = (TUser) iterator.next();
			System.out.println(tUser.toString());
		}
	}
	@Test
	public void insertUser() throws IOException{
		//通过注解方式执行sql语句
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		TUser tuser = new TUser();
		tuser.setPassword("11111111");
		tuser.setUserName("刘迅");
		tuser.setUserSex("1");
		
		int re = mapper.inserUser(tuser);
		if(re==1){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		session.commit();
	}
	@Test
	public void updateUser() throws IOException{
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		TUser tuser = new TUser();
		tuser.setPassword("11111111");
		tuser.setUserId(12);
		int re = mapper.updateUser(tuser);
		if(re==1){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		session.commit();
	}
	@Test
	public void del() throws IOException{
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		int re = mapper.delUser(19);
		if(re==1){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		session.commit();
	}
	@Test
	public void iftest() throws IOException{
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		TUser user = new TUser();
		//user.setUserName("lx");
		user.setUserSex("1");
		List<TUser> ul = mapper.findByParam(user);
		for (Iterator<TUser> iterator = ul.iterator(); iterator.hasNext();) {
			TUser tUser = (TUser) iterator.next();
			System.out.println(tUser.toString());
		}
		
	}
	@Test
	public void updatetest() throws IOException{
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		TUser user = new TUser();
		user.setUserName("lx");
		user.setUserSex("8");
		user.setPassword("iut");
//		user.setDelTag("0");
		user.setUserId(12);
		int re = mapper.updateByParam(user);
		if(re==1){
			System.out.println("update成功");
		}else{
			System.out.println("update失败");
		}
		
		
	}
	@Test
	public void inserttest() throws IOException{
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		TUser user = new TUser();
		user.setUserName("lx");
		user.setUserSex("8");
		user.setPassword("iut");
		user.setDelTag("0");
//		user.setUserId(12);
		int re = mapper.saveByParam(user);
		if(re==1){
			System.out.println("update成功");
		}else{
			System.out.println("update失败");
		}
		
		
	}
	@Test
	public void deletetest() throws IOException{
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		List<Integer> list = new ArrayList<Integer>();
		list.add(15);
		list.add(16);
		list.add(17);
		int re = mapper.delByListParam(list);
		if(re>0){
			System.out.println("批量删除成功");
		}else{
			System.out.println("批量删除失败");
		}
	}
	@Test
	public void deletetest2() throws IOException{
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		Integer[] ids = {1,2};
		int re = mapper.delByArrayParam(ids);
		if(re>0){
			System.out.println("批量删除成功");
		}else{
			System.out.println("批量删除失败");
		}
	}
	@Test
	public void wifetest() throws IOException{
		TWifeMapper mapper = session.getMapper(TWifeMapper.class);
		Wife w = mapper.findAllByWname("王月");
		System.out.println(w.toString());
		
	}
	@Test
	public void wifeMaptest() throws IOException{
		TWifeMapper mapper = session.getMapper(TWifeMapper.class);
		Map<String, Object> w = mapper.findWifeMapByWname("马伊俐");
		System.out.println(w.toString());
		
	}
	@Test
	public void deptmappertest() throws IOException{
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		Dept d = mapper.getDeptById(10);
		System.out.println(d.toString());
	}
	@Test
	public void deptTongYongMap() throws IOException{
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		List<Map<String, Object>> m = mapper.getDeptByIdMap(10);
		System.out.println(m);
	}
	@Test
	public void selectCartList() throws IOException{
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		List<Map<String, Object>> m = mapper.selectCartList(9,10001);
		System.out.println(m);
	}
	@Test
	public void multiInsert() throws IOException{
		TUserMapper mapper = session.getMapper(TUserMapper.class);
		List<TUser> list = new ArrayList<TUser>();
		TUser u1 = new TUser();
		u1.setUserName("1");
		u1.setUserSex("1");
		u1.setPassword("1");
		u1.setDelTag("1");
		TUser u2 = new TUser();
		u2.setUserName("2");
		u2.setUserSex("2");
		u2.setPassword("2");
		u2.setDelTag("3");
		TUser u3 = new TUser();
		u3.setUserName("3");
		u3.setUserSex("3");
		u3.setPassword("3");
		u3.setDelTag("3");
		list.add(u1);
		list.add(u2);
		list.add(u3);
		System.out.println(list);
		int re = mapper.multiInsert(list);
		if(re>0){
			System.out.println("批量插入成功");
		}else{
			System.out.println("批量插入失败");
		}
	}
	
}
