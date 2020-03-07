import com.hzm.init.config.AppConfig;
import com.hzm.init.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : hzm
 * @date : 2020-02-29 23:18
 */

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDao bean = context.getBean(UserDao.class);
        bean.query();

    }
}
