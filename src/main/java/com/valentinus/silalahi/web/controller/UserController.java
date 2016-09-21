package com.valentinus.silalahi.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.valentinus.silalahi.web.dao.UserDao;
import com.valentinus.silalahi.web.entity.User;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserDao ud;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Page<User> cariUser(Pageable page) {
		return ud.findAll(page);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void insertUserBaru(@RequestBody @Valid User u) {
		ud.save(u);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@PathVariable("id") Integer id, @RequestBody @Valid User u) {
		u.setId(id);
		ud.save(u);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> cariUserById(@PathVariable("id") String id) {
		User hasil = ud.findOne(id);
		if (hasil == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(hasil, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void hapusUser(@PathVariable("id") String id) {
		ud.delete(id);
	}
}
