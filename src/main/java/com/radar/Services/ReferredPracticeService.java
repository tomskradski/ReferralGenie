package com.radar.Services;

import com.radar.Models.ReferredPractice;
import org.springframework.stereotype.Service;

@Service
public interface ReferredPracticeService {

    boolean processNewPractice(ReferredPractice referredPractice);
}
