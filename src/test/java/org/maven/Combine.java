package org.maven;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
	
	@RunWith(Suite.class)
	@Suite.SuiteClasses({TestNG.class,TestNG1.class})
	
	public class Combine {
		public static void main(String[] args) {
		Result r = JUnitCore.runClasses(TestNG.class,TestNG1.class);
		System.out.println(r.getFailureCount());
		System.out.println(r.getIgnoreCount());
		System.out.println(r.getRunCount());
		System.out.println(r.getRunTime());
		System.out.println(r.wasSuccessful());
        
		List<Failure> failures = r.getFailures();
		for (Failure failure : failures) {
		System.out.println(failure);
}
}
	}