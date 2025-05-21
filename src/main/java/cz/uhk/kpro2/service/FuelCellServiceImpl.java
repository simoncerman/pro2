package cz.uhk.kpro2.service;

import cz.uhk.kpro2.model.FuelCell;
import cz.uhk.kpro2.repository.FuelCellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelCellServiceImpl implements FuelCellService {

    private final FuelCellRepository fuelCellRepository;

    @Autowired
    public FuelCellServiceImpl(FuelCellRepository fuelCellRepository) {
        this.fuelCellRepository = fuelCellRepository;
    }

    @Override
    public List<FuelCell> getAllFuelCells() {
        return fuelCellRepository.findAll();
    }

    @Override
    public FuelCell getFuelCell(long id) {
        Optional<FuelCell> fuelCell = fuelCellRepository.findById(id);
        return fuelCell.orElse(null);
    }

    @Override
    public void saveFuelCell(FuelCell fuelCell) {
        fuelCellRepository.save(fuelCell);
    }

    @Override
    public void deleteFuelCell(long id) {
        fuelCellRepository.deleteById(id);
    }
}
