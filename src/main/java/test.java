import com.lanou.upms.bean.User;
import com.lanou.upms.mapper.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {

        InputStream is= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        TestMapper testMapper =   sqlSession.getMapper(TestMapper.class);

       List<User> user = testMapper.queryAll();
         for( User user1 :user){
             System.out.println(user1);
      }



    }
}
