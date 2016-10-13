package com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Yun on 2016/10/10.
 */
public class LockImp {
    private Lock lock=new ReentrantLock();
    private ReadWriteLock rwLock=new ReentrantReadWriteLock();

    private List<Integer> list=new ArrayList<Integer>();

    public void doReentrantLock(Thread thread){
        lock.lock();
        System.out.println(thread.getName()+"获取锁");
        try {
            for(int i=0;i<10;i++){
                list.add(i);
            }
        } catch (Exception e) {

        }finally{
            lock.unlock();
            System.out.println(thread.getName()+"释放锁");
        }

    }
    public void doReentrantReadLock(Thread thread){
        rwLock.readLock().lock();
        System.out.println(thread.getName()+"获取读锁");
        try {
            for(int i=0;i<10;i++){
                list.add(i);
            }
        } catch (Exception e) {

        }finally{
            rwLock.readLock().unlock();
            System.out.println(thread.getName()+"释放读锁");
        }

    }
    public void doReentrantWriteLock(Thread thread){
        rwLock.writeLock().lock();
        System.out.println(thread.getName()+"获取写锁");
        try {
            for(int i=0;i<10;i++){
                list.add(i);
            }
        } catch (Exception e) {

        }finally{
            rwLock.writeLock().unlock();
            System.out.println(thread.getName()+"释放写锁");
        }

    }



    /**
     * @param args
     */
    public static void main(String[] args) {

        final LockImp lockImp=new LockImp();

        final Thread thread1=new Thread("Thread1");
        final Thread thread2=new Thread("Thread2");
        final Thread thread3=new Thread("Thread3");

        new Thread(new Runnable() {

            @Override
            public void run() {
                lockImp.doReentrantLock(thread1);
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                lockImp.doReentrantLock(thread2);
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                lockImp.doReentrantLock(thread3);
            }
        }).start();


        lockImp.doReentrantReadLock(thread1);
        lockImp.doReentrantReadLock(thread2);
        lockImp.doReentrantReadLock(thread3);

        lockImp.doReentrantWriteLock(thread1);
        lockImp.doReentrantWriteLock(thread2);
        lockImp.doReentrantWriteLock(thread3);
    }
}
