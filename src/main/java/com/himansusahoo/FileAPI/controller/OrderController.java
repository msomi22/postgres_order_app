package com.himansusahoo.FileAPI.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import com.himansusahoo.FileAPI.bean.Response;
import com.himansusahoo.FileAPI.service.OderService;


@RestController
@RequestMapping("/order")
@ControllerAdvice
public class OrderController {
	
	//http://localhost:8082/order/upload/v1
	@Autowired
	private OderService oderService;
	
	@Value("${file.upload-dir}")
	private String uploadFolder;
	
	@Value("${uploader.usethread}")
	private boolean useThread;
	
	//
	
	
	@RequestMapping(value="upload/v1", method = RequestMethod.POST ,
			consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
			produces =  {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Response> postFile(@RequestPart("file") MultipartFile file,
			HttpServletRequest httpRequest) {
		 System.out.println("Received Request ..... uploadFolder = " + uploadFolder);
		return oderService.uploadFile(file, uploadFolder, useThread);
	}
	
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<Response> handleFileSizeError() {
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(0, "Rejected")); 
	}

	@ExceptionHandler(MissingServletRequestPartException.class)
	public ResponseEntity<Response> handleBadRequestError() {
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(0, "Rejected")); 
	}

	@ExceptionHandler(Error.class)
	public ResponseEntity<Response> fileNotFound() {
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(0, "Rejected")); 
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> serverError() {
		return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(0, "Rejected")); 
	}

	

}
