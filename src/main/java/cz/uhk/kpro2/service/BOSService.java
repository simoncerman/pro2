package cz.uhk.kpro2.service;

import cz.uhk.kpro2.model.BOSMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BOSService {
    List<BOSMember> getAllBOSMembers();
    BOSMember getBOSMember(long id);
    void saveBOSMember(BOSMember bos);
    void deleteBOSMember(long id);
}
