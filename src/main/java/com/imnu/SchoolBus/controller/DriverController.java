package com.imnu.SchoolBus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imnu.SchoolBus.pojo.Driver;
import com.imnu.SchoolBus.service.DriverService;

@Controller
//@RequestMapping(value="admin",method = RequestMethod.POST)
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@RequestMapping(value="getDriverList")
	//@ResponseBody
	public String driverList(Model model) {
		List<Driver> drivers = driverService.getDriverList();
		model.addAttribute("drivers", drivers);
		//System.out.print(drivers);
		return "admin/driver-list";
	}
	
	@RequestMapping(value="saveDriver")
	public String createDriver(Driver driver) {
		driverService.createDriver(driver);
		//System.out.println(driver);
		return "redirect:/getDriverList";
	}
	
	@GetMapping(value="delete/{dId}")
	public String deleteDriver(@PathVariable Integer dId) {
		driverService.deleteDriver(dId);
		return "redirect:/getDriverList";
	}
	
    @RequestMapping("/toEdit")
    public String toEdit(Model model,int dId) {
        Driver driver=driverService.findDriverById(dId);
        model.addAttribute("driver", driver);
        return "admin/driverEdit";
    }
 
    @RequestMapping("/edit")
    public String edit(Driver driver) {
    	driverService.updateDriver(driver);
        return "redirect:/getDriverList";
    }

	
}
