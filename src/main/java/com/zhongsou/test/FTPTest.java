package com.zhongsou.test;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

/**
 * Created by Administrator on 2017/11/6.
 */
public class FTPTest {

    /**
     * Description: 向FTP服务器上传文件
     * @Version1.0 Jul 27, 2008 4:31:09 PM by 崔红保（cuihongbao@d-heaven.com）创建
     * @param url FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param path FTP服务器保存目录
     * @param filename 上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;

            ftp.connect(url, port);//连接FTP服务器
            ftp.enterLocalActiveMode();
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            System.out.println("ftp login==>"+ftp.login(username, password));//登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(filename, input);

            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    public void testUpLoadFromDisk(){
        try {
            FileInputStream in=new FileInputStream(new File("F:\\小程序\\java\\springboot\\SpringBootTest-0.0.1.jar"));
            boolean flag = uploadFile("54.64.130.77", 21, "ftptest", "123456", "/home/ftptest", "SpringBootTest-0.0.1.jar", in);
            System.out.println(flag);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        testUpLoadFromDisk();
//    }
}


