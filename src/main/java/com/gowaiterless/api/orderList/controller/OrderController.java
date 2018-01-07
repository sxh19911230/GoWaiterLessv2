package com.gowaiterless.api.orderList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gowaiterless.api.orderList.Order;
import com.gowaiterless.api.orderList.service.OrderService;

@RestController
@RequestMapping("restaurant/{restaurantid}/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Order> getOrders(@PathVariable String restaurantid) {
		return orderService.getOrders(restaurantid);
	}
	
	@RequestMapping(value="/{orderid}",method=RequestMethod.GET)
	public Order getOrder(@PathVariable String restaurantid, @PathVariable long orderid) {
		return orderService.getOrder(restaurantid, orderid);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Order> placeOrder(@PathVariable String restaurantid, @RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.placeOrder(restaurantid, order));
	}
	
	@RequestMapping(value="/{orderid}",method=RequestMethod.PUT)
	public Order updateOrder(@PathVariable String restaurantid, @PathVariable long orderid, @RequestBody Order order) {
		return orderService.updateOrder(restaurantid, orderid, order);
	}
	
	@RequestMapping(value="/{orderid}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteOrder(@PathVariable String restaurantid, @PathVariable long orderid) {
		orderService.deleteOrder(restaurantid, orderid);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
}
