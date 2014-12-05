package threadPoolExecutor.scheduled.ch08;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
	
	private String name;
	
	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run(){
		System.out.printf("%s: Staring at : %s\n", name, new Date());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
