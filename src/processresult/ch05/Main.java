package processresult.ch05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * һ���û����Ա����ֻ�����֤�����ʹ������һ��������֤ͨ�����û�����ȷ����֤ͨ����
 * @author LiHao
 *
 */
public class Main {
	public static void main(String[] args) {
		String username="test";
		String password="test";
		
		UserValidator ldapValidator=new UserValidator("�ڴ�");
		UserValidator dbValidator=new UserValidator("���ݿ�");

		TaskValidator ldapTask=new TaskValidator(ldapValidator,username, password);
		TaskValidator dbTask=new TaskValidator(dbValidator,username,password);

		List<TaskValidator> taskList=new ArrayList<TaskValidator>();
		taskList.add(ldapTask);
		taskList.add(dbTask);


		ExecutorService executor=(ExecutorService)Executors.newCachedThreadPool();
		String result;

		try {
			result = executor.invokeAny(taskList);
			System.out.printf("Main: Result: %s\n", result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		executor.shutdown();
		System.out.printf("Main: ����.....\n");


	}
}
