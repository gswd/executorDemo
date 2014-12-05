package threadPoolExecutor.processOneResult.ch05;


import java.util.Random;
import java.util.concurrent.TimeUnit;


public class UserValidator {
	private String name;
	
	public UserValidator(String name) {
		this.name = name;
	}
	
	public boolean validate(String name, String password){
		Random random = new Random();
		try {
			
			long duration = (long)(Math.random() * 10);
			System.out.printf("Validator %s: ��ʼ��֤����Ҫ %d ��\n",this.name,duration);
			
			TimeUnit.SECONDS.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean b = random.nextBoolean();
		System.out.printf("Validator %s: ��֤��ϣ�ֵΪ��" + b + "��\n",this.name);
		return b;
	}
	
	public String getName(){
		return this.name;
	}
}
