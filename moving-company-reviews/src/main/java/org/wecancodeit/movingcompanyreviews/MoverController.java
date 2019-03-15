package org.wecancodeit.movingcompanyreviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoverController {

	@Resource
	private MoverRepository moverRepo;

	@RequestMapping("/show-movers")
	public String findAllMovers(Model model) {
		model.addAttribute("moversModel", moverRepo.findAll());
		return "movers";
	}

	@RequestMapping("/show-mover")
	public String findOneStudent(@RequestParam Long id, Model model) throws MoverNotFoundException {
		
		if(moverRepo.findOne(id) == null) {
			throw new MoverNotFoundException();
		}
		
		model.addAttribute("moverModel", moverRepo.findOne(id));
		return "mover";
	}

}