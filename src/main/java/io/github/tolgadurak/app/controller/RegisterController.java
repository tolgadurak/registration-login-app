package io.github.tolgadurak.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

import io.github.tolgadurak.app.domain.User;
import io.github.tolgadurak.app.dto.RegistrationDto;
import io.github.tolgadurak.app.exception.UserAlreadyExistsException;
import io.github.tolgadurak.app.service.UserService;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
@Controller
public class RegisterController {
	private static final Logger logger = LogManager.getLogger(RegisterController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerGet(Model model) {
		RegistrationDto registrationDto = new RegistrationDto();
		model.addAttribute("registrationDto", registrationDto);
		return "register";
	}

	@PostMapping("/register")
	public ModelAndView registerPost(@ModelAttribute("registrationDto") @Valid RegistrationDto registrationDto,
			BindingResult result, Errors errors, WebRequest request, Model model) {
		List<String> errorMessages = new ArrayList<>();
		if (result.hasErrors()) {
			List<ObjectError> objectErrors = errors.getAllErrors();
			objectErrors.forEach(objectError -> errorMessages.add(objectError.getDefaultMessage()));
			model.addAttribute("validationErrors", errorMessages);
			return new ModelAndView("register");
		}
		try {
			User newUser = userService.registerNewUser(registrationDto);
			System.out.println(userService.getByEmail(newUser.getEmail()).toString());
		} catch (UserAlreadyExistsException e) {
			logger.debug(e.getMessage(), e);
			errorMessages.add(e.getMessage());
			model.addAttribute("validationErrors", errorMessages);
			return new ModelAndView("register");
		}

		return new ModelAndView("redirect:/login");
	}

}
