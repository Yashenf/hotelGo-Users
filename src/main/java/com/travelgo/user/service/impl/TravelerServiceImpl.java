package com.travelgo.user.service.impl;

import com.travelgo.user.dto.core.TravelerDTO;
import com.travelgo.user.dto.req.TravelerReqDTO;
import com.travelgo.user.entity.Traveler;
import com.travelgo.user.repo.TravelerRepo;
import com.travelgo.user.service.TravelerIdGenerator;
import com.travelgo.user.service.TravelerService;
import com.travelgo.user.service.s3.S3Service;
import com.travelgo.user.util.exceptions.EntryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class TravelerServiceImpl implements TravelerService {

    public final TravelerRepo repo;
    private final TravelerIdGenerator idGenerator;
    private final S3Service s3;

    @Autowired
    public TravelerServiceImpl(TravelerRepo repo, TravelerIdGenerator idGenerator, S3Service s3) {
        this.repo = repo;
        this.idGenerator = idGenerator;
        this.s3 = s3;
    }

    @Override
    public Traveler create(TravelerReqDTO dto) {
        // generate id
        Serializable generatedId = idGenerator.generate();
        // create entity
        Traveler traveler = new Traveler(
                generatedId.toString(),
                dto.getNic(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getGender(),
                dto.getDob(),
                dto.getContactNumber(),
                dto.getUserName(),
                dto.getPassword(),
                dto.isAccountNonExpired(),
                dto.isAccountNonLocked(),
                dto.isCredentialsNonExpired(),
                dto.isEnabled(),
               null,
                null
        );
        // save it and return.
        return repo.save(traveler);
    }

    @Override
    public Traveler findOne(String id) {
        Optional<Traveler> traveler = repo.findById(id);
        if (traveler.isPresent()){
            return traveler.get();
        }
        // throw exception
        throw new EntryNotFoundException(id+" Not Found.");
    }

    @Override
    public Traveler modify(TravelerDTO dto, String id) {
        // verify account
        if (repo.findById(id).isPresent()) {
            // create entity
            Traveler traveler = new Traveler(
                    id,
                    dto.getNic(),
                    dto.getFirstName(),
                    dto.getLastName(),
                    dto.getEmail(),
                    dto.getGender(),
                    dto.getDob(),
                    dto.getContactNumber(),
                    dto.getUserName(),
                    dto.getPassword(),
                    dto.isAccountNonExpired(),
                    dto.isAccountNonLocked(),
                    dto.isCredentialsNonExpired(),
                    dto.isEnabled(),
                    dto.getNicImage1(),
                    dto.getNicImage2()
            );
            // save
            return repo.save(traveler);
        }
        throw new EntryNotFoundException(id+" Not Found.");
    }

    @Override
    public String remove(String id) {
        Optional<Traveler> byId = repo.findById(id);
        if (byId.isPresent()){
            Traveler traveler = byId.get();
            repo.delete(traveler);
            return id;
        }
        throw new EntryNotFoundException(id+" Account Not Found!");
    }

    @Override
    public List<Traveler> findAll() {
        return repo.findAll();
    }

    @Override
    public Traveler updateImages(String id, MultipartFile file1, MultipartFile file2) {
        try {
            String url1 = s3.putObject(id, file1);
            String url2 = s3.putObject(id, file2);
            Traveler traveler = repo.findByNic(id);
            traveler.setNicImage1(url1);
            traveler.setNicImage2(url2);
            repo.save(traveler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
