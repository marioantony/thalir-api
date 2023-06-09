package com.pro.dev.api.resolver;

import com.pro.dev.api.entity.*;
import com.pro.dev.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private FarmerRepository farmerRepository;

	@Autowired
	private VehicleOwnerRepository vehicleOwnerRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private LoginRepository loginRepository;

	public  Iterable<FarmerLogin> loginUsers(){ return loginRepository.findAll();}

	public FarmerLogin farmerLogin(Long id) { return loginRepository.findById(id).orElseGet(null);}

	public  Iterable<Farmer> allFarmers(){ return farmerRepository.findAll();}

	public Farmer farmer(Long id) { return farmerRepository.findById(id).orElseGet(null);}

	public  Iterable<VehicleOwner> allVehicleOwners(){ return vehicleOwnerRepository.findAll();}

	public VehicleOwner vehicleOwner(Long id) { return vehicleOwnerRepository.findById(id).orElseGet(null);}

	public  Iterable<Schedule> allSchedules(){ return scheduleRepository.findAll();}

	public Schedule schedule(Long id) { return scheduleRepository.findById(id).orElseGet(null);}

//	public  Iterable<Order> allOrders(){ return orderRepository.findAll();}

//	public Order order(Long id) { return orderRepository.findById(id).orElseGet(null);}

	public  Iterable<Admin> allAdmins(){ return adminRepository.findAll();}

	public Admin admin(Long id) { return adminRepository.findById(id).orElseGet(null);}

	public Iterable<Book> allBooks() {
		return bookRepository.findAll();
	}

	public Book book(Long id) {
		return bookRepository.findById(id).orElseGet(null);
	}
}
