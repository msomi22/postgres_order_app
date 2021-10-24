package com.himansusahoo.FileAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.himansusahoo.FileAPI.repo.OrderRepository;
import com.himansusahoo.FileAPI.service.OderService;


@Controller
@ControllerAdvice
public class OrderController {
	
	@Autowired
	private OderService oderService;
	
	@Value("${file.upload-dir}")
	private String uploadFolder;
	
	@Value("${uploader.usethread}")
	private boolean useThread;
	
	@Autowired
	private OrderRepository orderRepo;
	
	
	@GetMapping
	public String getIndex(Model model) {
		model.addAttribute("msg", "Welcome to Order App");
		
		Pageable first = PageRequest.of(0, 10);
		
		model.addAttribute("orders", orderRepo.findAll(first));
		
		return "index";
	}
	
	
	@PostMapping("/upload")
	public String postFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
		
        if (file.isEmpty()) {
            attributes.addFlashAttribute("uploadRes", "Please select a file.");
            return "redirect:/";
        }
		
		 System.out.println("Received Request ..... uploadFolder = " + uploadFolder);
		 
		 oderService.uploadFile(file, uploadFolder, useThread);
		
		 attributes.addFlashAttribute("uploadRes", "Uplaoded Successfully");
         return "redirect:/";
	}
	
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleFileSizeError(RedirectAttributes attributes) {
		 attributes.addFlashAttribute("uploadRes", "Rejected");
         return "redirect:/";
	}

	@ExceptionHandler(MissingServletRequestPartException.class)
	public String handleBadRequestError(RedirectAttributes attributes) {
		 attributes.addFlashAttribute("uploadRes", "Rejected");
         return "redirect:/";
	}

	@ExceptionHandler(Error.class)
	public String fileNotFound(RedirectAttributes attributes) {
		 attributes.addFlashAttribute("uploadRes", "Rejected");
         return "redirect:/";
	}
	
	@ExceptionHandler(Exception.class)
	public String serverError(RedirectAttributes attributes) {
		 attributes.addFlashAttribute("uploadRes", "Rejected");
         return "redirect:/";
	}

	

}
