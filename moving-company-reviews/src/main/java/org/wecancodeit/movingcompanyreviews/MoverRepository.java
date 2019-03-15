package org.wecancodeit.movingcompanyreviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository

public class MoverRepository {

	private Map<Long,Mover> moverList = new HashMap<>();

	public MoverRepository() {
		Mover mover1 = new Mover(1L, "2Men&ATruck", "https://twomenandatruck.com/movers/il/chicago/downtown");
		Mover mover2 = new Mover(2L, "MrVans", "https://www.atlasvanlines.com/");
		
		moverList.put(mover1.getId(), mover1);
		moverList.put(mover2.getId(), mover2);
	}
	//builds
	public MoverRepository(Mover... movers) {
		for(Mover mover: movers) {
			moverList.put(mover.getId(), mover);
		}
		
	}

	public Mover findOne(long id) {
		return moverList.get(id);
	}

	public Collection<Mover> findAll() {
		return moverList.values();
	}

}
