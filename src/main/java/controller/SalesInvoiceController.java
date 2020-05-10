package controller;


import entity.SalesInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.SalesInvoiceService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class SalesInvoiceController {

    @Autowired
    private SalesInvoiceService salesInvoiceService;
    //Get all
    @RequestMapping(path= "saleinvoices",method = RequestMethod.GET)
    public List<SalesInvoice> getAllSalesInvoices(){
        return  salesInvoiceService.getAllSalesInvoices();
    }
    //Get by id
    @RequestMapping(path = "saleinvoice",method = RequestMethod.GET)
    public SalesInvoice getSalesInvoice(@RequestParam int id){
        return salesInvoiceService.getSalesInvoice(id);
    }
    //add new
    @RequestMapping(path = "saleinvoice",method = RequestMethod.POST)
    public SalesInvoice addSalesInvoices(@RequestBody SalesInvoice salesInvoice){
        return salesInvoiceService.addSalesInvoices(salesInvoice);
    }
    //Delete
    @RequestMapping(path = "saleinvoice/{id}",method = RequestMethod.DELETE)
    public int deleteSalesInvoices(@PathVariable int id){
        return salesInvoiceService.deleteSalesInvoices(id);
    }
    //Update
    @RequestMapping(path = "saleinvoice",method = RequestMethod.PUT)
    public SalesInvoice updateSalesInvoice(@RequestBody SalesInvoice salesInvoice){
        return salesInvoiceService.updateSalesInvoice(salesInvoice);
    }
}
