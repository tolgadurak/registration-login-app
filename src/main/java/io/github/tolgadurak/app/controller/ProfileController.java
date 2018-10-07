package io.github.tolgadurak.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
@Controller
public class ProfileController {
	@GetMapping("/profile")
	public String profileGet(Model model) {
		return "profile";
	}
}
