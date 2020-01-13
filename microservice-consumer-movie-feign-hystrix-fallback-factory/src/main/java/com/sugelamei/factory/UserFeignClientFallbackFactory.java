package com.sugelamei.factory;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.sugelamei.client.UserFeignClient;
import com.sugelamei.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
     return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                UserFeignClientFallbackFactory.LOGGER.info("fallback  reason was:",throwable);
                User user = new User();
                user.setId(-1L);
                user.setName("default");
                user.setDataBase("default");
                return user;
            }
        };

/*      return  new UserFeignClient() {
          @Override
          public User findById(Long id) {
              User user = new User();

              user.setName("default");
              user.setDataBase("default");

              if (throwable instanceof HystrixTimeoutException){
                  user.setId(-1L);
              }else {
                  user.setId(-2L);
              }
              return user;
          }
      };*/

    }
}
