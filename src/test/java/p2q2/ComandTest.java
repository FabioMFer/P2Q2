package p2q2;

import org.junit.Test;

public class ComandTest {
	
	@Test
	public void comandoTest(){
		VulnerableClass vC = new VulnerableClass();
		vC.vulnerableMethod("test.txt");
	}

}
