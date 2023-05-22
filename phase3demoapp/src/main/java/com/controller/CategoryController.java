package com.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Category;
import com.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/adminHome",method = RequestMethod.GET)
	public String back(Model mm, Category cc) {
		mm.addAttribute("category", cc);
		return "adminHome";
	}
	
	@RequestMapping(value = "/addCategoryPage",method = RequestMethod.GET)
	public String openAddCategoryPage(Model mm, Category cc) {
		mm.addAttribute("category", cc);
		return "addCategory";
	}
	
	
	@RequestMapping(value = "/storeCategoryInfo",method = RequestMethod.POST)
	public String storeAddCategoryPage(Model mm, Category cc) {
		cc.setPurchaseDate(LocalDate.now());
	
		String result = categoryService.storeCategory(cc);
		mm.addAttribute("category", cc);
		mm.addAttribute("msg", result);
		return "addCategory";
	}
	
	
	@RequestMapping(value = "/viewCategoryPage",method = RequestMethod.GET)
	public String viewCategory(Model mm, Category cc) {
		List<Category> listOfCategories = categoryService.findAllCategory();
		mm.addAttribute("category", listOfCategories);
		return "viewCategory";
	}
	
	@GetMapping("/purchaseReports")
	public String showPurchaseReportsPage(@RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
	                                      @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
	                                      @RequestParam(value = "category", required = false) String category,
	                                      Model model) {
	    if (startDate != null && endDate != null && category != null) {
	        // Filter based on the provided parameters
	       // List<Category> purchaseReports = categoryService.getFilteredPurchaseReports(startDate, endDate, category);
	       // model.addAttribute("purchaseReports", purchaseReports);
	    } else {
	        // Default behavior, show the page with current date and empty category
	        //model.addAttribute("startDate", LocalDate.now());
	       // model.addAttribute("endDate", LocalDate.now());
	       // model.addAttribute("category", "");
	    }
	    
	    return "purchaseReports";
	}


}
