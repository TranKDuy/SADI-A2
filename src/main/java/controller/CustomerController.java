package controller;


import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;


import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    //Get all
    @RequestMapping(path= "customers",method = RequestMethod.GET)
    public List<Customer> getAllCustomer(){
        return  customerService.getAllCustomer();
    }
    //Get by id
    @RequestMapping(path = "customer",method = RequestMethod.GET)
    public Customer getCustomer(@RequestParam int id){
        return customerService.getCustomer(id);
    }
    //add new
    @RequestMapping(path = "customer",method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    //Delete
    @RequestMapping(path = "customer/{id}",method = RequestMethod.DELETE)
    public int deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }
    //Update
    @RequestMapping(path = "customer",method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
}
