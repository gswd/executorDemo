package threadPoolExecutor.scheduled.ch07;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors
				.newScheduledThreadPool(1);

		System.out.printf("Main : Staring at : %s\n", new Date());

		for (int i = 0; i < 5; i++) {
			Task task = new Task("Task-" + i);
			executor.schedule(task, i + 1, TimeUnit.SECONDS);
			System.out.println("-------------------");
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main : End at %s\n", new Date());
	}
}
