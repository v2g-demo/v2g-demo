package com.v2gdemo.googlemap.database;


public interface ChargerDao {
    boolean save(String id,String location);
    String get(String id);
}
