package familytree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.rozart.familytree.FamilyTreeApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FamilyTreeApplication.class)
@WebAppConfiguration
public class FamilyTreeApplicationTests {

	@Test
	public void contextLoads() {
	}

}
