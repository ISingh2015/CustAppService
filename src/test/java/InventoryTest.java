
import com.inderjit.InventoryApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author Zed
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InventoryApplication.class)
@WebAppConfiguration
public class InventoryTest {

    @Test
    public void contextLoads() {
    }
}
