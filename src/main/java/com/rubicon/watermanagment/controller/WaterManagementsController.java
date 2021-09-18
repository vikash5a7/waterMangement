package com.rubicon.watermanagment.controller;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubicon.watermanagment.model.request.WaterRequest;
import com.rubicon.watermanagment.model.request.WaterUpdateStatusRequestModel;
import com.rubicon.watermanagment.model.response.Response;
import com.rubicon.watermanagment.model.response.WaterRest;
import com.rubicon.watermanagment.service.UserService;
import com.rubicon.watermanagment.service.WaterService;
import com.rubicon.watermanagment.shared.dto.WaterDto;

@RestController

@RequestMapping("/user/water-manage")
public class WaterManagementsController {
	@Autowired
	UserService userService;

	@Autowired
	WaterService waterService;

	@PostMapping("/{userId}")
	public ResponseEntity<Response> createOrder(@PathVariable String userId, @RequestBody WaterRequest waterRequest) {
		WaterDto waterDto = new WaterDto();
		WaterRest waterResponse = new WaterRest();
		BeanUtils.copyProperties(waterRequest, waterDto);
		if (!waterRequest.getStartingDate().after(new Date())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Starting time is must be greater than Now", 400));

		}
		if (!waterRequest.getEndingDate().after(waterRequest.getStartingDate())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Ending time is must be greater than Starting Time", 400));
		} else {
			WaterDto wateruserDto = waterService.CreateOrder(waterDto, userId);
			if (wateruserDto == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("User doesn't exit", 404));
			}
			BeanUtils.copyProperties(wateruserDto, waterResponse);
			return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Order Created ", 200, waterResponse));
		}

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Response> updateStatus(@PathVariable String id,
			@RequestBody WaterUpdateStatusRequestModel update) {
		WaterDto waterDto = new WaterDto();
		WaterRest waterResponse = new WaterRest();
		BeanUtils.copyProperties(update, waterDto);
		WaterDto serviceResponse = waterService.updateStatus(id, update);

		if (serviceResponse != null) {
			BeanUtils.copyProperties(serviceResponse, waterResponse);
			return ResponseEntity.status(HttpStatus.OK).body(new Response("Updated", 200, waterResponse));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new Response("User doesn't exit or Id not Exit", 404));

		}
	}

	@GetMapping(path = "status/{id}")
	public ResponseEntity<Response> getBasedOnStatus(@PathVariable String id, @RequestBody String status) {
		WaterDto waterDto = new WaterDto();
		WaterRest waterResponse = new WaterRest();
//		if (serviceResponse != null) {
//			BeanUtils.copyProperties(serviceResponse, waterResponse);
//			return ResponseEntity.status(HttpStatus.OK).body(new Response("Updated", 200, waterResponse));
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					.body(new Response("User doesn't exit or Id not Exit", 404));
//		}
		return null;
	}

	@GetMapping(path = "cancel-order/{id}")
	public ResponseEntity<Response> cancel(@PathVariable String id, @RequestBody String orderId) {
		WaterDto waterDto = new WaterDto();
		WaterRest waterResponse = new WaterRest();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("User doesn't exit or Id not Exit", 404));
	}
}
