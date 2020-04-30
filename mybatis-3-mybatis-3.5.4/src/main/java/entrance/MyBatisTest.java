package entrance;

import entrance.dao.TbItemMapper;
import entrance.entity.TbItem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

  private SqlSessionFactory sqlSessionFactory;

  @Before
  public void prepare() throws IOException {
    String resource = "entrance/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    inputStream.close();
  }

  @Test
  public void testSelectById() {
    SqlSession session = sqlSessionFactory.openSession();
    try {
      TbItemMapper tbItemMapper = session.getMapper(TbItemMapper.class);
      TbItem tbItem = tbItemMapper.selectByPrimaryKey(536563L);


      System.out.println();
      System.out.println("title info:");
      System.out.println(tbItem.getTitle());
      System.out.println();
      System.out.println("sell point info:");
      System.out.println(tbItem.getSellPoint());
    } finally {
      session.close();
    }
  }
}
