package com.cn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
public class ClientNet {
public static void main(String[] args){
try{
Socket s = new Socket("127.0.0.1",6060);
// 用于获取服务端传输来的信息
BufferedReader buff = new BufferedReader(new InputStreamReader(s.getInputStream()));
// 用于获取客户端准备响应的信息
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
// 发送客户端准备传输的信息
PrintWriter printWriter = new PrintWriter(s.getOutputStream(),true);
printWriter.println("有客房端请求连接!");
// 客户端使用线程池连接服务端
//     ExecutorService executorService = Executors.newCachedThreadPool();
//     executorService.execute(new ClientOutNet(printWriter,bufferedReader));
new ClientOutNet(printWriter,bufferedReader);
while(true){ // 显示服务端的响应信息
String str = buff.readLine();
if(str != null){
System.out.println(str);
}
//       System.out.println("To Server:");
Thread.sleep(100);
}
}catch(Exception e){
e.printStackTrace();
}
}
}
/**
* Client 发送线程 ，向服务端发送信息
* @author ids-user
*/
class ClientOutNet extends Thread{
private PrintWriter printWriter;
private BufferedReader bufferedReader;
ClientOutNet(PrintWriter pw,BufferedReader in){
this.printWriter = pw;
this.bufferedReader=in;
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
printWriter.println("From Client: " + inStr);
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
