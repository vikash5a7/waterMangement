package com.rubicon.watermanagment.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rubicon.watermanagment.model.request.UserDetailsRequestModel;
import com.rubicon.watermanagment.model.response.Response;
import com.rubicon.watermanagment.model.response.UserRest;
import com.rubicon.watermanagment.service.UserService;
import com.rubicon.watermanagment.shared.dto.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<Response> createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserDto userDto = new UserDto();
		UserRest userResponse = new UserRest();
		BeanUtils.copyProperties(userDetails, userDto);
		UserDto createUser = userService.CreateUser(userDto);
		BeanUtils.copyProperties(createUser, userResponse);
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response("User Created", 201, userResponse));
	}

	@PutMapping(path = "/{id}")
	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		UserDto userDto = new UserDto();
		userDto = new ModelMapper().map(userDetails, UserDto.class);
		UserDto updateUser = userService.updateUser(id, userDto);
		returnValue = new ModelMapper().map(updateUser, UserRest.class);
		return returnValue;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response> getUser(@PathVariable String id) {
		UserRest returnValue = new UserRest();
		UserDto userDto = userService.getUserByUserId(id);
		if(userDto==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("User doesn't exit", 404));
		}
		ModelMapper modelMapper = new ModelMapper();
		returnValue = modelMapper.map(userDto, UserRest.class);
		return ResponseEntity.status(HttpStatus.OK).body(new Response("User Found", 200, returnValue));
	}

	@GetMapping()
	public List<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "8") int limit) {
		List<UserRest> returnValue = new ArrayList<>();
		List<UserDto> users = userService.getUsers(page, limit);
		Type listType = new TypeToken<List<UserRest>>() {
		}.getType();
		returnValue = new ModelMapper().map(users, listType);
		return returnValue;
	}

}
