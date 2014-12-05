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
			System.out.printf("%s: 验证没通过\n",validator.getName());
			throw new Exception("用户没找到,验证不通过！");
		}
		System.out.println("===============================");
		System.out.printf("%s: 找到对应用户数据,并验证通过\n",validator.getName());
		return validator.getName();

	}
}
