package com.gowaiterless.api.menuList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gowaiterless.api.menuList.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {}
