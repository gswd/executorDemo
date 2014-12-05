package threadPoolExecutor.scheduled.ch08;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors
				.newScheduledThreadPool(10);

		System.out.printf("Main : Staring at : %s\n", new Date());

		Task task = new Task("Task");

		//第二个参数：一次执行终止和下一次执行开始之间的延迟
//		ScheduledFuture<?> result = executor.scheduleWithFixedDelay(task, 1, 2, TimeUnit.SECONDS);
		
		//第二个参数：连续执行之间的周期。如果此任务的任何一个执行要花费比其周期更长的时间，则将推迟后续执行，但不会同时执行
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
		for (int i = 0; i < 10; i++) {
			System.out.printf("Main: Delay: %d\n", result
					.getDelay(TimeUnit.MILLISECONDS));
			// 线程睡眠500毫秒
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		 executor.shutdown();

		System.out.printf("Main : End at %s\n", new Date());
	}
}
