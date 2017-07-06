package p2q2;

import org.junit.Test;

public class writeTest {

	@Test
	public void escritaTest() {
		VulnerableClass vC = new VulnerableClass();
		vC.vulnerableMethod("test.txt");
	}

}
