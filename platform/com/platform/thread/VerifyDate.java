package com.platform.thread;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 时间校验检测
 * 
 * @author mango  dongcb678@163.com
 * 
 * 描述：
 * 		校验更新系统时间的操作，会影响timer定时器的执行
 * 		1.系统时间往前调整，不会影响timer的触发
 * 		2.系统时间往后调整，timer会挂起
 * 		
 * 		此线程用来检测时间是否往后调整，如果是，则重置timer的调度
 */
public class VerifyDate extends Thread {

	private static Logger log = Logger.getLogger(VerifyDate.class);
	
	private static final long interval = 1000 * 60 * 10; // 10 分钟
	
	private static Date date = new Date();

	private static final VerifyDate verifyDate = new VerifyDate();
	
	@Override
	public void run() {
		synchronized (date) {
			
			while (true) {
				try {
					Date newDate = new Date();
					long milliSeconds = newDate.getTime() - date.getTime();
					if(milliSeconds < - interval){
						// 重新触发timer
						DataClear.stop();
						DataClear.start();
						
//						TimerResources.stop();
//						TimerResources.start();
						
						// 重置时间变量
						date = newDate;
					}
					
					sleep(interval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	public static synchronized void startVerify(){
		log.info("启动任务开始");
		verifyDate.start();
		log.info("启动任务成功");
	}
	
	public static synchronized void stopVerify(){
		log.info("任务退出开始");
		verifyDate.stop();
		log.info("任务退出成功");
	}
	
}
