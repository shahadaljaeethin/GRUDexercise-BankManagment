package com.example.bankmanagment.Controller;

import com.example.bankmanagment.Api.ApiResponse;
import com.example.bankmanagment.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Bank Managment")
public class CustomerController {
//create database
ArrayList<Customer> customers = new ArrayList<>();
//--------------------------------------
@GetMapping("/get")
public ArrayList<Customer> getAllCustomers(){
return customers;
}
@PostMapping("/add")
public ApiResponse addCustomer(@RequestBody Customer cust){
customers.add(cust);
return new ApiResponse("Customer added successfully.");
}
@PutMapping("/set/{index}")
public ApiResponse updateCustomer(@PathVariable int index, Customer c){
customers.set(index,c);
return new ApiResponse("Customer info updated successfully.");
}
@DeleteMapping("/delete/{index}")
public ApiResponse removeCustomer(@PathVariable int index)
{
customers.remove(index);
return new ApiResponse("deleted complete.");
}
@PutMapping("set/deposit/{index}")
public ApiResponse deposit(@PathVariable int index, double amount){
if(amount<=0) return new ApiResponse("Amount should be over zero");
customers.get(index).setBalance(customers.get(index).getBalance()+amount);
return new ApiResponse("deposit done completely, new balance:"+customers.get(index).getBalance());
}

}
