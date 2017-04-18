
import java.io.*;  
import java.util.*;  
import java.net.*;  
import java.text.*;  
  
public class Server  
{  
    public static void main(String[] args) throws Exception  
    {  
        //����������ServerSocket  
        ServerSocket ss = new ServerSocket(10000);  
        //��ʾServer�����ɹ�  
        System.out.println("Server online... " + ss.getInetAddress().getLocalHost().getHostAddress() + ", " + 10000);  
        //�����˿ڣ��������Ӳ������µ�ServerThread�߳������������  
        while(true)  
        {  
            //���տͻ���Socket  
            Socket s = ss.accept();  
            //��ȡ�ͻ���IP�Ͷ˿�  
            String ip = s.getInetAddress().getHostAddress();  
            int port = s.getPort();  
            //�����µķ������߳�, ����߳��ṩ������ServerSocket���ͻ���Socket���ͻ���IP�Ͷ˿�  
            new Thread(new ServerThread(s, ss, ip, port)).start();  
        }  
    }  
}  
  
class ServerThread implements Runnable  
{  
    //��ȡ�Ŀͻ���Socket  
    Socket s = null;  
    //��ȡ�ķ�����ServerSocket  
    ServerSocket ss = null;  
    //��ȡ�Ŀͻ���IP  
    String ip = null;  
    //��ȡ�Ŀͻ��˶˿�  
    int port = 0;  
    //��Ͽͻ��˵�ip�Ͷ˿��ַ����õ�uid�ַ���  
    String uid = null;  
      
    //��̬ArrayList�洢����uid��uid��ip�Ͷ˿��ַ���ƴ�Ӷ���  
    static ArrayList<String> uid_arr = new ArrayList<String>();  
    //��̬HashMap�洢����uid, ServerThread������ɵĶ�  
    static HashMap<String, ServerThread> hm = new HashMap<String, ServerThread>();  
      
    public ServerThread(Socket s, ServerSocket ss, String ip, int port)  
    {  
        this.s = s;  
        this.ss = ss;  
        this.ip = ip;  
        this.port = port;  
        uid = ip + ":" + port;  
    }  
  
    @Override  
    public void run()  
    {  
        //����ǰ�ͻ���uid����ArrayList  
        uid_arr.add(uid);  
        //����ǰuid��ServerThread�Դ���HashMap  
        hm.put(uid, this);  
  
        //ʱ����ʾ��ʽ  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
          
        //����̨��ӡ�ͻ���IP�Ͷ˿�  
        System.out.println("Client connected: " + uid);  
  
        try  
        {  
            //��ȡ������  
            InputStream in = s.getInputStream();  
            //��ȡ�����  
            OutputStream out = s.getOutputStream();  
  
            //��ǰ�ͻ��˴������ӳɹ���Ϣ  
            String welcome = sdf.format(new Date()) + "\n�ɹ����ӷ�����...\n������IP: " + ss.getInetAddress().getLocalHost().getHostAddress() + ", �˿�: 10000\n�ͻ���IP: " + ip + ", �˿�: " + port + "\n";  
            out.write(welcome.getBytes());  
  
            //�㲥������������   
            updateOnlineList(out);  
  
            //׼��������  
            byte[] buf = new byte[1024];  
            int len = 0;  
          
            //����������ת���ͻ�����Ϣ  
            while(true)  
            {  
                len = in.read(buf);  
                String msg = new String(buf, 0, len);  
                System.out.println(msg);  
                //��Ϣ���ͣ��˳���������  
                String type = msg.substring(0, msg.indexOf("/"));  
                //��Ϣ���壺�ջ�����������  
                String content = msg.substring(msg.indexOf("/") + 1);  
                //������Ϣ���ͷֱ���  
                //�ͻ���Ҫ�˳�  
                if(type.equals("Exit"))  
                {  
                    //����ArrayList��HashMap, ɾ���˳���uid���߳�  
                    uid_arr.remove(uid_arr.indexOf(uid));  
                    hm.remove(uid);  
                    //�㲥������������  
                    updateOnlineList(out);  
                   //����̨��ӡ�ͻ���IP�Ͷ˿�  
                    System.out.println("Client exited: " + uid);  
                    //����ѭ���������÷����߳�  
                    break;  
                }  
                //�ͻ���Ҫ����  
                else if(type.equals("Chat"))  
                {  
                    //��ȡ�����ߵ�ַ  
                    String[] receiver_arr = content.substring(0, content.indexOf("/")).split(",");  
                    //��ȡ��������  
                    String word = content.substring(content.indexOf("/") + 1);  
                    //�������߹㲥����������Ϣ  
                    chatOnlineList(out, uid, receiver_arr, word);  
                }  
            }  
        }  
        catch(Exception e){}  
    }  
      
    //�����������ӵĿͻ��˸�����������  
    public void updateOnlineList(OutputStream out) throws Exception  
    {  
        for(String tmp_uid : uid_arr)  
            {  
                //��ȡ�㲥�����ߵ������  
                out = hm.get(tmp_uid).s.getOutputStream();  
                //����ǰ���������Զ���Ϊ�ָ���ϳɳ��ַ���һ�δ���  
                StringBuilder sb = new StringBuilder("OnlineListUpdate/");  
                for(String member : uid_arr)  
                {  
                    sb.append(member);  
                    //�Զ��ŷָ�uid���������һ��  
                    if(uid_arr.indexOf(member) != uid_arr.size() - 1)  
                        sb.append(",");  
                }  
                out.write(sb.toString().getBytes());  
            }  
    }  
  
    //��ָ���Ŀͻ��˷���������Ϣ  
    public void chatOnlineList(OutputStream out, String uid, String[] receiver_arr, String word) throws Exception  
    {  
        for(String tmp_uid : receiver_arr)  
            {  
                //��ȡ�㲥�����ߵ������  
                out = hm.get(tmp_uid).s.getOutputStream();  
                //����������Ϣ  
                out.write(("Chat/" + uid + "/" + word).getBytes());  
            }  
    }   
}  