package com.travelgo.user.controller;

import com.travelgo.user.dto.core.TravelerDTO;
import com.travelgo.user.dto.req.TravelerReqDTO;
import com.travelgo.user.entity.Traveler;
import com.travelgo.user.service.TravelerIdGenerator;
import com.travelgo.user.service.TravelerService;
import com.travelgo.user.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/travelers")
public class TravelerController {
    public final TravelerService service;

    @Autowired
    public TravelerController(TravelerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody TravelerReqDTO dto){
        System.out.println(dto);

        Traveler traveler = service.create(dto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        "New Account Created",
                        traveler
                ), HttpStatus.OK
        );
    }

    @PutMapping("/img")
    public ResponseEntity<StandardResponse> updateImages(
            @RequestParam MultipartFile file1,
            @RequestParam MultipartFile file2,
            @RequestParam String nic
    ){


        Traveler traveler = service.updateImages(nic,file1,file2);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        "New Account Created",
                        traveler
                ), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findOne(@PathVariable String id){
        Traveler traveler = service.findOne(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "Data Found!",
                        traveler
                ), HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> modify(@RequestBody TravelerDTO dto, @RequestParam String id){
        Traveler traveler = service.modify(dto, id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        204,
                        "Account Updated",
                        traveler
                ), HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> remove(@RequestParam String id){
        String removedAccId = service.remove(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        204,
                        "Account Deleted!",
                        id
                ), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> findAll(){
        List<Traveler> all = service.findAll();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        204,
                        "All Data Set",
                        all
                ), HttpStatus.OK
        );

    }

}
