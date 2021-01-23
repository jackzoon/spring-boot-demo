package com.halen.cache;

import com.halen.cache.model.User;
import com.halen.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootDemoCacheEhcacheApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void getTwice() {
        User user1 = userService.get(1L);
        log.debug("[user1] = {}", user1);

        User user2 = userService.get(1L);
        log.debug("[user2] = {}", user2);
    }


    /**
     * 先存，再查询，查看日志验证缓存
     */
    @Test
    public void getAfterSave() {
        userService.saveOrUpdate(new User(4L, "user4"));

        User user = userService.get(4L);
        log.debug("【user】= {}", user);
        // 查看日志，只打印保存用户的日志，查询是未触发查询日志，因此缓存生效
    }

    /**
     * 测试删除，查看redis是否存在缓存数据
     */
    @Test
    public void deleteUser() {
        // 查询一次，使ehcache中存在缓存数据
        userService.get(1L);
        // 删除，查看ehcache是否存在缓存数据
        userService.delete(1L);
    }


}
