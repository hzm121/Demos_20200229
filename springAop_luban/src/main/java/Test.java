import com.hzm.config.AppConfig;
import com.hzm.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

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
