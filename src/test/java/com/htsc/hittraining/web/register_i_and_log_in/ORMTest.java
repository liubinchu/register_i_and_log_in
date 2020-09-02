package com.htsc.hittraining.web.register_i_and_log_in;

import Entity.User;
import com.htsc.hittraining.web.register_i_and_log_in.Dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;
import java.util.*;


/**
 * @author liubi
 * @date 2020-09-02 09:19
 **/
@SpringBootTest
public class ORMTest {
    @Autowired
    private UserDao userDao;

    @Test
    @Rollback
    public void test() throws Exception {
        User u1 = userDao.findByName("BBB");
        System.out.println(u1);
    }

/*    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        List<User> userList = userDao.findAll();
        for(User user : userList) {
            System.out.println(user);
            Assert.isNull(user.getUserId());
            Assert.notNull(user.getPassword());
            Assert.notNull(user.getUserName());
        }
    }*/
}
