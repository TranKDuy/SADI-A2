package controller;
import entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.StaffService;
import java.util.List;
@RestController
@RequestMapping(path = "/")
public class StaffController {
    @Autowired
    private StaffService staffService;
    //Get all
    @RequestMapping(path= "staffs",method = RequestMethod.GET)
    public List<Staff> getAllStaff(){
        return  staffService.getAllStaff();
    }
    //Get by id
    @RequestMapping(path = "staff",method = RequestMethod.GET)
    public Staff getStaff(@RequestParam int id){
        return staffService.getStaff(id);
    }
    //add new
    @RequestMapping(path = "staff",method = RequestMethod.POST)
    public Staff addStaff(@RequestBody Staff staff){
        return staffService.addStaff(staff);
    }
    //Delete
    @RequestMapping(path = "staff/{id}",method = RequestMethod.DELETE)
    public int deleteStaff(@PathVariable int id){
        return staffService.deleteStaff(id);
    }
    //Update
    @RequestMapping(path = "staff",method = RequestMethod.PUT)
    public Staff updateStaff(@RequestBody Staff staff){
        return staffService.updateStaff(staff);
    }
}
