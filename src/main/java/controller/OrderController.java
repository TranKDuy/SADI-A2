package controller;

import entity.ProviderOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.OrderService;

import java.util.List;

@RestController
@RequestMapping(path ="/")
public class OrderController {
    @Autowired
    private OrderService orderService;
    //Get all
    @RequestMapping(path= "providerorders",method = RequestMethod.GET)
    public List<ProviderOrder> getAllOrders(){
        return  orderService.getAllOrders();
    }
    //Get by id
    @RequestMapping(path = "providerorder",method = RequestMethod.GET)
    public ProviderOrder getProduct(@RequestParam int id){
        return orderService.getOrder(id);
    }
    //add new
    @RequestMapping(path = "providerorder",method = RequestMethod.POST)
    public ProviderOrder addOrder(@RequestBody ProviderOrder order){
        return orderService.addOrder(order);
    }
    //Delete
    @RequestMapping(path = "providerorder/{id}",method = RequestMethod.DELETE)
    public int deleteOrder(@PathVariable int id){
        return orderService.deleteOrder(id);
    }

}
