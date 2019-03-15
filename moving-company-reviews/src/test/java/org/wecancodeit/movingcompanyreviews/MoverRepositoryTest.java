package org.wecancodeit.movingcompanyreviews;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.util.Collection;

import org.junit.Test;
import org.springframework.stereotype.Repository;
import org.wecancodeit.movingcompanyreviews.Mover;
import org.wecancodeit.movingcompanyreviews.MoverRepository;

@Repository

public class MoverRepositoryTest {
	Mover mover1 = new Mover(1L, "2Men&ATruck", "https://twomenandatruck.com/movers/il/chicago/downtown");
	Mover mover2 = new Mover(2L, "MrVans", "https://www.atlasvanlines.com/");
	
	@Test
	public void shouldFindMover1() {
		MoverRepository underTest = new MoverRepository(mover1);
		Mover foundMover = underTest.findOne(1L);
		assertThat(foundMover, is(mover1));
	}
	
	@Test
	public void shouldFindMover2() {
		MoverRepository underTest = new MoverRepository(mover2);
		Mover foundMover = underTest.findOne(2L);
		assertThat(foundMover, is(mover2));
	}
	
	@Test
	public void shouldFindAllMovers() {
		MoverRepository underTest = new MoverRepository(mover1,mover2);
		Collection<Mover> foundMovers = underTest.findAll();
		assertThat(foundMovers, containsInAnyOrder(mover1,mover2));
	}
}
