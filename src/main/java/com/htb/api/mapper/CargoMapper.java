package com.htb.api.mapper;

import com.htb.api.entity.Cargo;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
/**
 * Mapper和resources目录下的mapping文件对应
 */
public interface CargoMapper {
    Cargo selectCargoById(int id);

    List<Cargo> selectAllCargo();

    int addCargo(Cargo cargo);

    int updateCargo(int id, String attr, Object newValue);

    int updateFullCargo(Cargo cargo);

    int deleteCargo(int id);



}
