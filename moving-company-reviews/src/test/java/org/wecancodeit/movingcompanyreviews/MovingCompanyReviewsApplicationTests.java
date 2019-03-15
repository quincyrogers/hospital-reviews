package org.wecancodeit.movingcompanyreviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.movingcompanyreviews.MoverController;
import org.wecancodeit.movingcompanyreviews.MoverRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovingCompanyReviewsApplicationTests {

	@Autowired
	private MoverRepository moverRepo;
	
	@Autowired
	private MoverController moverController;
	
	//sanity check buddy
	@Test
	public void contextLoads() {
		assertThat(moverRepo).isNotNull();
	}
	

}

