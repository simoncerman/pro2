package cz.uhk.kpro2.service;

import cz.uhk.kpro2.model.FuelCell;

import java.util.List;

public interface FuelCellService {
    List<FuelCell> getAllFuelCells();
    FuelCell getFuelCell(long id);
    void saveFuelCell(FuelCell fuelCell);
    void deleteFuelCell(long id);
}
