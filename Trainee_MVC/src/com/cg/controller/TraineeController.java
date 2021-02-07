/**
 * 
 */
package com.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bean.Trainee;
import com.cg.exception.TraineeException;
import com.cg.service.ITraineeService;

/**
 * @author aruravic
 *
 */
@Controller
public class TraineeController {

	@Autowired
	ITraineeService traineeService;

	public ITraineeService getTraineeService() {
		return traineeService;
	}

	public void setTraineeService(ITraineeService traineeService) {
		this.traineeService = traineeService;
	}

	@RequestMapping("/showHomePage")
	public String homePage() {
		return "operation";
	}

	@RequestMapping("/showAddTraineeMethod")
	public ModelAndView addTrainee() {
		ModelAndView mv = new ModelAndView("addTrainee");
		Trainee bean = new Trainee();
		mv.addObject("add", bean);
		return mv;
	}

	@RequestMapping("/addTrainee")
	public ModelAndView add(@ModelAttribute("add") @Valid Trainee trainee,
			BindingResult result) {

		ModelAndView mv = new ModelAndView();

		if (!result.hasErrors()) {
			trainee = traineeService.addTrainee(trainee);
			mv = new ModelAndView("operation");
		} else {
			mv.setViewName("addTrainee");
			mv.addObject("add", trainee);
		}

		return mv;
	}

	@RequestMapping("/showDeleteTraineeMethod")
	public ModelAndView deleteTrainee() {
		ModelAndView mv = new ModelAndView("deleteTrainee");
		Trainee bean = new Trainee();
		mv.addObject("del", bean);
		return mv;
	}

	@RequestMapping("/deleteTrainee")
	public ModelAndView delete(@ModelAttribute("del") Trainee trainee) {
		ModelAndView mv = new ModelAndView();
		Trainee tBean = new Trainee();
		tBean = traineeService.getTrainee(trainee.getTraineeId());
		if (tBean != null) {
			mv.setViewName("deleteTrainee");
			mv.addObject("tBean", tBean);
			mv.addObject("isFirst", false);
		} else {
			mv.setViewName("error");
			mv.addObject("msg",
					"Trainee with TraineeId  " + trainee.getTraineeId()
							+ "not found.");
		}
		return mv;

	}

	@RequestMapping("/delTrainee")
	public ModelAndView deleteTrainee(@ModelAttribute("tBean") Trainee trainee) {
		ModelAndView mv = new ModelAndView("operation");

		traineeService.deleteTrainee(trainee.getTraineeId());
		return mv;

	}

	@RequestMapping("/showUpdateTraineeMethod")
	public ModelAndView updateTrainee() {
		Trainee trainee = new Trainee();
		ModelAndView mv = new ModelAndView("updateTrainee");

		mv.addObject("trainee", trainee);
		mv.addObject("isFirst", true);
		return mv;
	}

	@RequestMapping("/updateTrainee")
	public ModelAndView modifyTrainee(@ModelAttribute("trainee") Trainee trainee) {
		ModelAndView mv = new ModelAndView();
		Trainee tBean = new Trainee();
		tBean = traineeService.getTrainee(trainee.getTraineeId());
		if (tBean != null) {
			mv.setViewName("updateTrainee");
			mv.addObject("tBean", tBean);
			mv.addObject("isFirst", false);
		} else {
			mv.setViewName("error");
			mv.addObject("msg",
					"Trainee with TraineeId  " + trainee.getTraineeId()
							+ "not found.");
		}
		return mv;
	}

	@RequestMapping("/modifyTrainee")
	public ModelAndView UpdateTrainee(@ModelAttribute("tBean") Trainee trainee) {
		ModelAndView mv = new ModelAndView("operation");

		traineeService.updateTrainee(trainee);
		return mv;

	}

	@ExceptionHandler(TraineeException.class)
	public ModelAndView throwError(TraineeException e) {
		return new ModelAndView("error", "msg", e.getMessage());

	}

}