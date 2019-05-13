package com.ffxl.platform.util.eap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.ffxl.platform.util.PasswordHelper;

public class DefaultIdGenerator implements IdGenerator, Runnable {

    private String time;
    
    private AtomicInteger value;
    
    private static final DateFormat FORMATTER = new SimpleDateFormat("yyyyMMddHHmmss");
    
    private IdGeneratorConfig config;
    
    private Thread thread;
    
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    public DefaultIdGenerator(){
        config = new DefaultIdGeneratorConfig();
        time = DefaultIdGenerator.FORMATTER.format(new Date());
        value = new AtomicInteger(config.getInitial());
        
        thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }
    
    public DefaultIdGenerator(IdGeneratorConfig config){
        this.config = config;
        time = DefaultIdGenerator.FORMATTER.format(new Date());
        value = new AtomicInteger(config.getInitial());
        
        thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }
    
    public void run() {
        while (true){
            try {
                Thread.sleep(1000 * config.getRollingInterval());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String now = DefaultIdGenerator.FORMATTER.format(new Date());
            if (!now.equals(time)){
                lock.writeLock().lock();
                time = now;
                value.set(config.getInitial());
                lock.writeLock().unlock();
            }
        }
    }

    public String next() {
        lock.readLock().lock();
        StringBuffer sb = new StringBuffer(config.getPrefix()).append(config.getSplitString()).append(time).append(config.getSplitString()).append(value.getAndIncrement());
        lock.readLock().unlock();
        
        return toMd5AndAes(sb.toString());
    }

    public String toMd5AndAes(String str) {
        String md5Str = PasswordHelper.encryptPassword(str, str);
        md5Str = md5Str.substring(6,22);
        return getStr(md5Str);
//        String ase="";
//        try {
//            ase = PasswordHelper.aesEncrypt(md5Str, PasswordHelper.PASSWORDAES);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
////        return md5Str;
//        return ase;
    }
    
    
    public String getStr(String str){
        String str1="";
        String str2="";
        for(int i=0;i<str.length();i++){
            if(i%2==0){
                str1=str1+str.charAt(i);
            }else{
                str2=str2+str.charAt(i);
            }
        }
//        System.out.println("奇数位的字符串:"+str1);
//        System.out.println("偶数位的字符串:"+str2);
        return str2;
    }

}
