package com.gowaiterless.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gowaiterless.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, String> {}
