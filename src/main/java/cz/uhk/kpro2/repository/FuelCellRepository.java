package cz.uhk.kpro2.repository;

import cz.uhk.kpro2.model.FuelCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelCellRepository extends JpaRepository<FuelCell, Long> {
}
