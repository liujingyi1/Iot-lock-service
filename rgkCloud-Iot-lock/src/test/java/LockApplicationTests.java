import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rgk.domain.PositionView;
import com.rgk.repository.IRoomDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LockApplicationTests {
	
	@Autowired
	IRoomDao roomDao;
	
	@Test
	public void TestPosition() {
		PositionView positionView = roomDao.findPositionViewById("4028d0b76c27f7f4016c27fcfd280003");
		System.out.println(positionView.toString());
	}

}
