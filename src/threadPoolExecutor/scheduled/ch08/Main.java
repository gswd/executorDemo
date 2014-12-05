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

		//�ڶ���������һ��ִ����ֹ����һ��ִ�п�ʼ֮����ӳ�
//		ScheduledFuture<?> result = executor.scheduleWithFixedDelay(task, 1, 2, TimeUnit.SECONDS);
		
		//�ڶ�������������ִ��֮������ڡ������������κ�һ��ִ��Ҫ���ѱ������ڸ�����ʱ�䣬���Ƴٺ���ִ�У�������ͬʱִ��
		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
		for (int i = 0; i < 10; i++) {
			System.out.printf("Main: Delay: %d\n", result
					.getDelay(TimeUnit.MILLISECONDS));
			// �߳�˯��500����
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
