package com.sugelamei.controller;

import com.google.common.collect.Maps;
import com.sugelamei.entity.User;
import com.sugelamei.service.AggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

@RestController
public class AggregationController {

    private static  final Logger LOGGER = LoggerFactory.getLogger(AggregationController.class);

    @Autowired
    private AggregationService aggregationService;

    @GetMapping("/aggregation/{id}")
    public DeferredResult<HashMap<String, User>> aggregation(@PathVariable("id") Long id){
        Observable<HashMap<String, User>> result = this.aggregationObservable(id);
        return this.toDeferredResult(result);
    }
    public Observable<HashMap<String, User>> aggregationObservable( Long id){
        //合并2个或者多个Observable发射出的数据项，根据指定的函数变化它们
        return Observable.zip(
                aggregationService.getUserById(id),
                aggregationService.getUserByIdToMovie(id),
                (user,movieUser)->{
                    HashMap<String,User> map = Maps.newHashMap();
                    map.put("user",user);
                    map.put("movieUser",movieUser);
                    return map;
                }
        );

    }
    public DeferredResult<HashMap<String, User>> toDeferredResult(Observable<HashMap<String, User>>  datails){

        DeferredResult<HashMap<String, User>> result=  new DeferredResult<>();
        //订阅
        datails.subscribe(new Observer<HashMap<String, User>>() {
            @Override
            public void onCompleted() {
                LOGGER.info("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                LOGGER.info("onError",throwable);
            }

            @Override
            public void onNext(HashMap<String, User> stringUserHashMap) {
               result.setResult(stringUserHashMap);
            }
        });
        return result;
    }
}
