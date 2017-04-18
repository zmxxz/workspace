package com.cn;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;
public class ServerNet {
// 以毫秒为单位
private final static long timeLimit = 10000 ;
private Map<String,String> map = Collections.synchronizedMap(new HashMap<String,String>());
public void ServerSocketNet(){
try{
ServerSocket ss = new ServerSocket(6060);
Socket s = ss.accept();
// 用于获取客户端传输来的信息
BufferedReader buff = new BufferedReader(new InputStreamReader(s.getInputStream()));
// 用于获取服务端准备响应的信息
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
// 发送服务端准备响应的信息
PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
pw.println("您已经成功建立连接!");
new ServerOutNet(pw, in);
new ServerTimeListener(map, timeLimit);
// 显示客户端的传输来的信息
while(true){
String str = buff.readLine();
if(str.equals("exit")){
break;
}else{
map.put(ServerHelper.getInstance().getMapKey(), str);
System.out.println(str + "     map.size: " + map.size());
}
System.out.println("To Client:");
Thread.sleep(100);
}
s.close();
}catch(Exception e){
e.printStackTrace();
}
}
public static void main(String[] args){
new ServerNet().ServerSocketNet();
}
}
/**
* server发送线程 向客户端发送响应信息
* @author ids-user
*
*/
class ServerOutNet extends Thread{
private PrintWriter printWriter;
private BufferedReader bufferedReader;
ServerOutNet(PrintWriter pw,BufferedReader in){
this.printWriter = pw;
this.bufferedReader = in;
start();
}
public void run(){
while(true){
try{
String inStr = bufferedReader.readLine();
if(inStr.equals("exit")){
printWriter.close();
bufferedReader.close();
break;
}else{
printWriter.println("From Server: " + inStr);
}
sleep(300);
}catch(Exception e){
printWriter = null;
bufferedReader = null;
throw new RuntimeException(e);
}
}
}
}
// 时间监听线程类。
class ServerTimeListener extends Thread{
private long timeLimit;
Map<String, String> map = new HashMap<String, String>();
// 单例
// private ServerTimeListener(){}
// private final static ServerTimeListener stl = new ServerTimeListener();
// public static ServerTimeListener getInstance(){
//   return stl;
// }
ServerTimeListener(Map<String, String> map , long timeLimit){
this.map = map;
this.timeLimit = timeLimit;
start();
}
public void run(){
while(true){
try{
// 循环map
long currentTime = System.currentTimeMillis();
for(String mapKey : map.keySet()){
long oldTime = Long.parseLong(mapKey.substring(0, mapKey.indexOf("_")));
System.out.println("currentTime - oldTime=" + (currentTime - oldTime));
if(currentTime - oldTime >= timeLimit){
map.remove(mapKey);
}
}
TimeUnit.MILLISECONDS.sleep(timeLimit);
}catch(Exception e){
throw new RuntimeException(e);
}
}
}
}

