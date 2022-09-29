package poppin.org;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class Runnerclasspoppin {

	@Test
	public void tc5() {
		Result rs = JUnitCore.runClasses(Browserlaunchjunit.class);

		System.out.println("Run Count is:"+rs.getRunCount());
		System.out.println("Failure Count is:"+rs.getFailureCount());
		System.out.println("Ignore Count is:"+rs.getIgnoreCount());
	List<Failure> li = rs.getFailures();
		
	for (Failure x : li) {
		System.out.println(x);
		
	
	}
	}
}