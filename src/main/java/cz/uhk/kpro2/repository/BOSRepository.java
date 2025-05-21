package cz.uhk.kpro2.repository;

import cz.uhk.kpro2.model.BOSMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BOSRepository extends JpaRepository<BOSMember, Long> {

}
