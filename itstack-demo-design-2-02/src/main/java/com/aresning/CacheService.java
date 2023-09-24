package com.aresning;

import java.util.concurrent.TimeUnit;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-09-24 12:15
 * @description :
 */
public interface CacheService {
    public String get(String key);

    public void set(String key, String value);

    public void set(String key, String value, long timeout, TimeUnit timeUnit);

    public void del(String key);
}
