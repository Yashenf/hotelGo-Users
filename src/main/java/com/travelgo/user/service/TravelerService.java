package com.travelgo.user.service;

import com.travelgo.user.dto.core.TravelerDTO;
import com.travelgo.user.dto.req.TravelerReqDTO;
import com.travelgo.user.entity.Traveler;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TravelerService {
    Traveler create(TravelerReqDTO dto);
    Traveler findOne(String id);
    Traveler modify(TravelerDTO dto, String id);
    String remove(String id);
    List<Traveler> findAll();
    Traveler updateImages(String id, MultipartFile file1, MultipartFile file2);
}
