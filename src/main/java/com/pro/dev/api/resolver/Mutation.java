package com.pro.dev.api.resolver;

import com.pro.dev.api.entity.*;
import com.pro.dev.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import java.time.LocalDateTime;

@Component
public class Mutation implements GraphQLMutationResolver {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private VehicleOwnerRepository vehicleOwnerRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private FarmerRepository farmerRepository;

	public Book addBook (Integer requestedBag, Integer acceptedBag, Double amountPerBag, Double totalAmount, Long schedule_id, Long farmer_id){
		Schedule schedule = scheduleRepository.findById(schedule_id).orElseGet(null);
		Farmer farmer = farmerRepository.findById(farmer_id).orElseGet(null);
		Book book = new Book();
		book.setRequestedBag(requestedBag);
		book.setAcceptedBag(acceptedBag);
		book.setAmountPerBag(amountPerBag);
		book.setTotalAmount(totalAmount);
		book.setFarmer(farmer);
		book.setSchedule(schedule);

		return bookRepository.saveAndFlush(book);
	}

	public Book updateBook (Long id, Integer requestedBag, Integer acceptedBag, Double amountPerBag, Double totalAmount){
		Book book = new Book();
		book.setId(id);
		book.setRequestedBag(requestedBag);
		book.setAcceptedBag(acceptedBag);
		book.setAmountPerBag(amountPerBag);
		book.setTotalAmount(totalAmount);

		return bookRepository.saveAndFlush(book);
	}

	public Boolean deleteBook (Long id) {
		bookRepository.deleteById(id);
		return true;
	}

	public Schedule addSchedule (String date, Integer maxAllowedBag, String departureTime, String departureLocation, Long vehicleOwner_id){
		VehicleOwner vehicleOwner = vehicleOwnerRepository.findById(vehicleOwner_id).orElseGet(null);
		Schedule schedule = new Schedule();
		schedule.setDate(date);
		schedule.setMaxAllowedBag(maxAllowedBag);
		schedule.setDepartureTime(departureTime);
		schedule.setDepartureLocation(departureLocation);
		schedule.setVehicleOwner(vehicleOwner);

		return scheduleRepository.saveAndFlush(schedule);
	}

	public Schedule updateSchedule (Long id, String date, Integer maxAllowedBag, String departureTime, String departureLocation){

		Schedule schedule = new Schedule();
		schedule.setId(id);
		schedule.setDate(date);
		schedule.setMaxAllowedBag(maxAllowedBag);
		schedule.setDepartureTime(departureTime);
		schedule.setDepartureLocation(departureLocation);

		return scheduleRepository.saveAndFlush(schedule);
	}

	public Boolean deleteSchedule (Long id) {
		farmerRepository.deleteById(id);
		return true;
	}

	public VehicleOwner addVehicleOwner (String firstName, String lastName, String email, String password, String address, String phoneNumber, String vehicleName, String vehicleType, String bagCapacity){
		VehicleOwner vehicleOwner = new VehicleOwner();
		vehicleOwner.setFirstName(firstName);
		vehicleOwner.setLastName(lastName);
		vehicleOwner.setEmail(email);
		vehicleOwner.setPassword(password);
		vehicleOwner.setAddress(address);
		vehicleOwner.setPhoneNumber(phoneNumber);
		vehicleOwner.setVehicleName(vehicleName);
		vehicleOwner.setVehicleType(vehicleType);
		vehicleOwner.setBagCapacity(bagCapacity);

		return vehicleOwnerRepository.saveAndFlush(vehicleOwner);
	}

	public VehicleOwner updateVehicleOwner (Long id, String firstName, String lastName, String email, String password, String address, String phoneNumber, String vehicleName, String vehicleType, String bagCapacity){
		VehicleOwner vehicleOwner = new VehicleOwner();
		vehicleOwner.setId(id);
		vehicleOwner.setFirstName(firstName);
		vehicleOwner.setLastName(lastName);
		vehicleOwner.setEmail(email);
		vehicleOwner.setPassword(password);
		vehicleOwner.setAddress(address);
		vehicleOwner.setPhoneNumber(phoneNumber);
		vehicleOwner.setVehicleName(vehicleName);
		vehicleOwner.setVehicleType(vehicleType);
		vehicleOwner.setBagCapacity(bagCapacity);

		return vehicleOwnerRepository.saveAndFlush(vehicleOwner);
	}

	public Boolean deleteVehicleOwner (Long id) {
		vehicleOwnerRepository.deleteById(id);
		return true;
	}

	public Farmer addFarmer (String firstName, String lastName, String email, String password, String address, String phoneNumber, String currentCrops, String futureCrops){
		Farmer farmer = new Farmer();
		farmer.setFirstName(firstName);
		farmer.setLastName(lastName);
		farmer.setEmail(email);
		farmer.setPassword(password);
		farmer.setAddress(address);
		farmer.setPhoneNumber(phoneNumber);
		farmer.setCurrentCrops(currentCrops);
		farmer.setFutureCrops(futureCrops);

		return farmerRepository.saveAndFlush(farmer);
	}

	public Farmer updateFarmer(Long id, String firstName, String lastName, String email, String password, String address, String phoneNumber, String currentCrops, String futureCrops){
		Farmer farmer = new Farmer();
		farmer.setId(id);
		farmer.setFirstName(firstName);
		farmer.setLastName(lastName);
		farmer.setEmail(email);
		farmer.setPassword(password);
		farmer.setAddress(address);
		farmer.setPhoneNumber(phoneNumber);
		farmer.setCurrentCrops(currentCrops);
		farmer.setFutureCrops(futureCrops);

		return farmerRepository.saveAndFlush(farmer);
	}

	public Boolean deleteFarmer (Long id) {
		farmerRepository.deleteById(id);
		return true;
	}

	public Admin addAdmin(String username, String password){
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);

		return adminRepository.saveAndFlush(admin);
	}

	public Admin updateAdmin(Long id, String username, String password) {
		Admin admin = new Admin();
		admin.setId(id);
		admin.setUsername(username);
		admin.setPassword(password);

		return adminRepository.saveAndFlush(admin);
	}

	public Boolean deleteAdmin (Long id) {
		adminRepository.deleteById(id);
		return true;
	}

	public Author addAuthor(String firstname) {
		Author author = new Author();
		author.setName(firstname);

		return authorRepository.saveAndFlush(author);
	}

	public Author updateAuthor(Long id, String firstname) {
		Author author = new Author();
		author.setId(id);
		author.setName(firstname);

		return authorRepository.saveAndFlush(author);
	}

	public Boolean deleteAuthor(Long id) {
		authorRepository.deleteById(id);
		return true;
	}

//	public Book addBook(String name, Double price, Long author_id) {
//		Author author = authorRepository.findById(author_id).
//		orElseGet(null);
//		Book book = new Book();
//		book.setName(name);
//		book.setPrice(price);
//		book.setAuthor(author);
//		return bookRepository.saveAndFlush(book);
//	}
//
//	public Book updateBook(Long id, String name, Double price) {
//		Book book = new Book();
//		book.setId(id);
//		book.setName(name);
//		book.setPrice(price);
//		return bookRepository.saveAndFlush(book);
//	}
//
//	public Boolean deleteBook(Long id) {
//		bookRepository.deleteById(id);
//		return true;
//	}

}
