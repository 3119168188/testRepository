package com.huarui.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJob {
	
	//固定的周期执行
	@Scheduled(fixedDelay=5000)
	public void testJob01() {
		System.out.println("每5秒执行一次_delay");
	}
	
	@Scheduled(fixedRate=5000)
	public void testJob02() {
		System.out.println("每5秒执行一次_rate");
	}
	
	//执行时间点执行
	@Scheduled(cron="0 48 8 * * ?")
	public void testJob03() {
		System.out.println("指定时间执行");
	}

}
