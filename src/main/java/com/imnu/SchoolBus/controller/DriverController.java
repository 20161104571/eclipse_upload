package com.imnu.SchoolBus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imnu.SchoolBus.pojo.Driver;
import com.imnu.SchoolBus.service.DriverService;

@Controller
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@RequestMapping(value="getDriverList")
	public String driverList(Model model, @RequestParam(required = false, value = "pageNum", defaultValue = "1")Integer pageNum,
							@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
		if(pageNum == null) {
			pageNum = 1;
		}
		if(pageNum <= 0) {
			pageNum = 1;
		}
		if(pageSize == null) {
			pageSize = 5;
		}
		PageHelper.startPage(pageNum, pageSize);
		try {
			List<Driver> dl = driverService.getDriverList();
			PageInfo<Driver> pl = new PageInfo<Driver>(dl, pageSize);
			model.addAttribute("pageInfo", pl);
		}finally {
			PageHelper.clearPage();
		}
		return "admin/driver-list";
	}
	
	@RequestMapping(value="saveDriver")
	public String createDriver(Driver driver) {
		driverService.createDriver(driver);
		return "redirect:/getDriverList";
	}
	
	@RequestMapping(value="delete")
	public String deleteDriver(Integer dId) {
		driverService.deleteDriver(dId);
		return "redirect:/getDriverList";
	}
	
    @RequestMapping("toEdit")
    public String toEdit(Model model,int dId) {
        Driver driver=driverService.findDriverById(dId);
        model.addAttribute("driver", driver);
        return "admin/driverEdit";
    }
 
    @RequestMapping("edit")
    public String edit(Driver driver) {
    	driverService.updateDriver(driver);
        return "redirect:/getDriverList";
    }

	
}
