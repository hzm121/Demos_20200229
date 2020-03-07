package com.hzm.redis.enums;

/**
 * @author : hzm
 * @date : 2020-03-08 00:05
 */
public enum SexEnum {
    male("男"),
    female("女");
        private String type;
    SexEnum(String type){
        this.type = type;
    }
    public String getValue(){
        return type;
    }
}
