package controller;

import entity.InventoryDeliveryNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.InventoryDeliveryService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class InventoryDeliveryController {
    @Autowired
    private InventoryDeliveryService inventoryDeliveryService;
    @RequestMapping(path = "ids",method = RequestMethod.GET)
    public InventoryDeliveryService getDeliveryNote(@RequestParam int id){
        return inventoryDeliveryService.getDeliveryNote(id);
    }

    @RequestMapping(path = "ids",method = RequestMethod.POST)
    public InventoryDeliveryService addDeliveryNote(@RequestBody InventoryDeliveryService inventoryDeliveryService){
        return inventoryDeliveryService.addDeliveryNote(inventoryDeliveryService);
    }

    @RequestMapping(path = "ids",method = RequestMethod.PUT)
    public InventoryDeliveryService updateDeliveryNote(@RequestBody InventoryDeliveryService inventoryDeliveryService){
        return inventoryDeliveryService.updateDeliveryNote(inventoryDeliveryService);
    }
    @RequestMapping(path = "ids/{id}",method = RequestMethod.DELETE)
    public int deleteDeliveryNote(@PathVariable int id){
        return inventoryDeliveryService.deleteDeliveryNote(id);
    }

    @RequestMapping(path = "ids/search",method = RequestMethod.GET)
    public List<InventoryDeliveryNote> getDeliveryNoteByDate(@RequestParam(required = false) String s){
        return inventoryDeliveryService.findDeliveryNote(s);
    }
}
