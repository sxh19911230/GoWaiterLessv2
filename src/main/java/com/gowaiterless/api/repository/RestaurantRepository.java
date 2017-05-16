package com.gowaiterless.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gowaiterless.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {}
