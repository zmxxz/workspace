package com.cn;

import java.util.Random;
public class ServerHelper {
// 单例
private ServerHelper(){ }
private final static ServerHelper helper = new ServerHelper();
public static ServerHelper getInstance(){
return helper;
}
// 构建map的key值
public String getMapKey(){
Random random = new Random();
String mapKey = System.currentTimeMillis() + "_" + random.nextInt(1000);
System.out.println("map key: " + mapKey);
return mapKey;
}
}
