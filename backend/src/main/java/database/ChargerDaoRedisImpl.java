package com.v2gdemo.googlemap.database;


import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Repository
public class ChargerDaoRedisImpl implements ChargerDao {
    private static final Jedis JEDIS = new Jedis("localhost",6379);


    @Override
    public boolean save(String id,String location) {
        JEDIS.set(id,location);

        return true;
    }

    @Override
    public String get(String id) {
        return JEDIS.get(id);
    }
}
