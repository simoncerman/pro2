package cz.uhk.kpro2.service;

import cz.uhk.kpro2.model.BOSMember;
import cz.uhk.kpro2.repository.BOSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BOSServiceImpl implements BOSService {

    private final BOSRepository bosRepository;

    @Autowired
    public BOSServiceImpl(BOSRepository bosRepository) {
        this.bosRepository = bosRepository;
    }

    @Override
    public List<BOSMember> getAllBOSMembers() {
        return bosRepository.findAll();
    }


    @Override
    public BOSMember getBOSMember(long id) {
        Optional<BOSMember> bos = bosRepository.findById(id);
        return bos.orElse(null);
    }

    @Override
    public void saveBOSMember(BOSMember bos) {
        bosRepository.save(bos);
    }

    @Override
    public void deleteBOSMember(long id) {
        bosRepository.deleteById(id);
    }
}
