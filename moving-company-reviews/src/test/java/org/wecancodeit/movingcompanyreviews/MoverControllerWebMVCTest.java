package org.wecancodeit.movingcompanyreviews;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.movingcompanyreviews.Mover;
import org.wecancodeit.movingcompanyreviews.MoverController;
import org.wecancodeit.movingcompanyreviews.MoverRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@WebMvcTest(MoverController.class)

public class MoverControllerWebMVCTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MoverRepository moverRepo;

	@Mock
	private Mover mover1;
	Long idOne = 1L;

	@Mock
	private Mover mover2;

	@Test
	public void shouldReturnOkWhenFindAllMovers() throws Exception {
		when(moverRepo.findAll()).thenReturn(Arrays.asList(mover1, mover2));
		mockMvc.perform(get("/show-movers")).andExpect(status().isOk());
		mockMvc.perform(get("/show-movers")).andExpect(view().name("movers"));

	}

	@Test
	public void shouldAddAllMoverToTheModel() throws Exception {
		when(moverRepo.findAll()).thenReturn(Arrays.asList(mover1, mover2));
		mockMvc.perform(get("/show-movers")).andExpect(model().attribute("moversModel", hasSize(2)));
	}

	@Test
	public void shouldReturnOkWhenFindOneMover() throws Exception {
		when(moverRepo.findOne(1L)).thenReturn(mover1);
		mockMvc.perform(get("/show-mover?id=1")).andExpect(status().isOk());
		mockMvc.perform(get("/show-mover?id=1")).andExpect(view().name("mover"));

	}

	@Test
	public void shouldAddMoverToModel() throws Exception {
		when(moverRepo.findOne(1L)).thenReturn(mover1);
		mockMvc.perform(get("/show-mover?id=1")).andExpect(model().attribute("moverModel", is(mover1)));

	}

	// smoke test buddy

}