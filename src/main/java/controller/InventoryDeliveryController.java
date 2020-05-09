package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.InventoryDeliveryService;

@RestController
@RequestMapping(path = "/")
public class InventoryDeliveryController {
    @Autowired
    private InventoryDeliveryService inventoryDeliveryService;
    @RequestMapping(path = "IDS",method = RequestMethod.GET)
    public InventoryDeliveryService getDeliveryNote(@RequestParam int id){
        return inventoryDeliveryService.getDeliveryNote(id);
    }

    @RequestMapping(path = "IDS",method = RequestMethod.POST)
    public InventoryDeliveryService addDeliveryNote(@RequestBody InventoryDeliveryService inventoryDeliveryService){
        return inventoryDeliveryService.addDeliveryNote(inventoryDeliveryService);
    }

    @RequestMapping(path = "IDS",method = RequestMethod.PUT)
    public InventoryDeliveryService updateDeliveryNote(@RequestBody InventoryDeliveryService inventoryDeliveryService){
        return inventoryDeliveryService.updateDeliveryNote(inventoryDeliveryService);
    }
    @RequestMapping(path = "IDS/{id}",method = RequestMethod.DELETE)
    public int deleteDeliveryNote(@PathVariable int id){
        return inventoryDeliveryService.deleteDeliveryNote(id);
    }
}
