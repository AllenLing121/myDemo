package com.ling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Lian on 04/22/2019.
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Semaphore semaphore = new Semaphore(2,true);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i<20 ; i++){
            executorService.submit(new Thread(new SaveMoneyThread(bank,semaphore)));
        }

        executorService.shutdown();

        semaphore.acquireUninterruptibly(2);
        System.out.println("到点了，工作人员要去吃饭了。");
        Thread.sleep(5000);
        System.out.println("工作人员吃完饭回来继续上班。");
        semaphore.release(2);
    }

}

class Bank{
    private int account = 100;

    public int getAccount(){
        return this.account;
    }

    public void saveMoney(int money) throws InterruptedException {
        this.account += money;
        Thread.sleep(3000);
    }

}

class SaveMoneyThread implements Runnable{
    private Bank bank;
    private Semaphore semaphore;

    public SaveMoneyThread(Bank bank, Semaphore semaphore) {
        this.bank = bank;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        if(semaphore.availablePermits() > 0){
            System.out.println(Thread.currentThread().getName() + "启动，进入银行有空位去存钱。");
        }else{
            System.out.println(Thread.currentThread().getName() + "启动，进入银行没有空位，先去排队等候。");
        }

        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "线程开始存钱。");

            bank.saveMoney(10);

            System.out.println(Thread.currentThread().getName() + "线程存钱完毕，准备离开。");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}