package io.github.tolgadurak.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.github.tolgadurak.app.dto.LoginDto;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
@Controller
public class LoginController {

	@GetMapping("/login")
	public String loginGet(Model model) {
		LoginDto loginDto = new LoginDto();
		model.addAttribute("loginDto", loginDto);
		return "login";
	}

	@PostMapping("/login")
	public ModelAndView loginPost(@ModelAttribute("loginDto") @Valid LoginDto loginDto, BindingResult result,
			Errors errors, WebRequest request, RedirectAttributes redirectAttributes) {
		List<String> errorMessages = new ArrayList<>();
		if (result.hasErrors()) {
			List<ObjectError> objectErrors = errors.getAllErrors();
			objectErrors.forEach(objectError -> errorMessages.add(objectError.getDefaultMessage()));
			redirectAttributes.addFlashAttribute("validationErrors", errorMessages);
			return new ModelAndView("redirect:/login");
		}
		return new ModelAndView("redirect:/profile");
	}

}
