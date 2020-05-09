package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import service.InventoryReceivingService;

@RestController
@RequestMapping(path = "/")
public class InventoryReceivingController {
    @Autowired
    private InventoryReceivingService inventoryReceivingService;
    @RequestMapping(path = "irs",method = RequestMethod.GET)
    public InventoryReceivingService getReceivingNote(@RequestParam int id){
        return inventoryReceivingService.getReceivingNote(id);
    }
    @RequestMapping(path = "irs",method = RequestMethod.POST)
    public InventoryReceivingService addReceivingNote(@RequestBody InventoryReceivingService inventoryReceivingService){
        return inventoryReceivingService.addReceivingNote(inventoryReceivingService);
    }
    @RequestMapping(path = "irs",method = RequestMethod.PUT)
    public InventoryReceivingService updateReceivingNote(@RequestBody InventoryReceivingService inventoryReceivingService){
        return inventoryReceivingService.updateReceivingNote(inventoryReceivingService);
    }
    @RequestMapping(path = "irs/{id}",method = RequestMethod.DELETE)
    public int deleteReceivingNote(@PathVariable int id){
        return inventoryReceivingService.deleteReceivingNote(id);
    }
}