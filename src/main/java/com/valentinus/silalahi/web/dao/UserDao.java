package com.valentinus.silalahi.web.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.valentinus.silalahi.web.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, String> {

}
