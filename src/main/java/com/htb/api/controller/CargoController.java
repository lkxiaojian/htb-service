package com.htb.api.controller;

import com.htb.api.entity.Cargo;
import com.htb.api.service.CargoService;

import com.htb.api.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @RequestMapping("selectCargoById/{id}")
    public String GetUser(@PathVariable int id){
        return cargoService.selectCargoById(id).toString();
    }

    @RequestMapping("selectAllCargo")
    public List<Cargo> selectAllCargo() {
        return cargoService.selectAllCargo();
    }

    // 这里可以直接返回新加入值的id
    @PostMapping("addCargo")
    public Response addCargo(Cargo param) throws Exception {
        cargoService.addCargo(param);
        return new Response(200, param.getId());
    }

    @PostMapping("updateCargo")
    public Response updateCargo(@RequestParam Map<String,String> data) {
        return new Response(200 ,cargoService.updateCargo(Integer.parseInt(data.get("id")), data.get("attr"), data.get("newValue")));
    }

    @PostMapping("updateFullCargo")
    public Response updateFullCargo(@RequestBody Cargo param) {
        return new Response(200 ,cargoService.updateFullCargo(param));
    }

    @PostMapping("deleteCargo")
    public Response deleteCargo(@RequestParam Map<String,String> data) {
        System.out.println("data" + data);
        return new Response(200, cargoService.deleteCargo(Integer.parseInt(data.get("id"))));
    }

}
