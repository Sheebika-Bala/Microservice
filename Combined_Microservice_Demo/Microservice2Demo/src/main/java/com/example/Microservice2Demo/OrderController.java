package com.example.Microservice2Demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public OrderWithUser getOrderWithUser(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        User user = restTemplate.getForObject("http://localhost:8081/users/" + order.getUserId(), User.class);
        return new OrderWithUser(order, user);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order details) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setUserId(details.getUserId());
        order.setItemName(details.getItemName());
        order.setPrice(details.getPrice());
        return orderRepository.save(order);
    }
}
