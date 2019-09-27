package com.radar.Services;

import com.radar.JPA.Entities.ReferredPracticeEntity;
import com.radar.JPA.Repositories.ReferredPracticeRepository;
import com.radar.Models.ReferredPractice;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ReferredPracticeServiceImpl implements ReferredPracticeService {

    @Autowired
    ReferredPracticeRepository referredPracticeRepository;

    @Override
    public boolean processNewPractice(ReferredPractice referredPractice) {

        ModelMapper mapper = new ModelMapper();
        ReferredPracticeEntity referredPracticeEntity = mapper.map(referredPractice, ReferredPracticeEntity.class);
        try {
            referredPracticeRepository.save(referredPracticeEntity);
        }
        catch (Exception e){
            System.err.println("Error persisting referredPracticeEntity:" + e);
            return false;
        }

        return true;
    }
}
