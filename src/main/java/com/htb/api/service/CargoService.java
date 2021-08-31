package com.htb.api.service;

import com.htb.api.mapper.CargoMapper;
import com.htb.api.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * 服务层
 */
public class CargoService {

    @Autowired
    CargoMapper cargoMapper;
    public Cargo selectCargoById(int id){
        return cargoMapper.selectCargoById(id);
    }

    public List<Cargo> selectAllCargo() {
        return cargoMapper.selectAllCargo();
    }

    public int addCargo(Cargo cargo) {
        return cargoMapper.addCargo(cargo);
    }

    public int updateCargo(int id, String attr, Object newValue) {
        return cargoMapper.updateCargo(id, attr, newValue);
    }

    public int updateFullCargo(Cargo cargo) {
        return cargoMapper.updateFullCargo(cargo);
    }

    public int deleteCargo(int id) {
        return cargoMapper.deleteCargo(id);
    }
}
