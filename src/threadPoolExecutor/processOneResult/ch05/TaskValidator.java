package threadPoolExecutor.processOneResult.ch05;


import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {

	private UserValidator validator;
	private String user;
	private String password;

	public TaskValidator(UserValidator validator, String user, String password) {
		this.validator = validator;
		this.user = user;
		this.password = password;
	}

	@Override
	public String call() throws Exception {
		
		if(!validator.validate(user, password)){
			System.out.printf("%s: ��֤ûͨ��\n",validator.getName());
			throw new Exception("�û�û�ҵ�,��֤��ͨ����");
		}
		System.out.println("===============================");
		System.out.printf("%s: �ҵ���Ӧ�û�����,����֤ͨ��\n",validator.getName());
		return validator.getName();

	}
}
