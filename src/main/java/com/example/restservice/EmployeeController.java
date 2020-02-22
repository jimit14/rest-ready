package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
	private static EmployeeRepository repository = new EmployeeRepository();
//	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return repository.get(id);
	}
	@GetMapping("/employee")
	public String welcome() {
		return "Hi Welcome to the employee management system";
	}
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return repository.add(employee);
	}
}
