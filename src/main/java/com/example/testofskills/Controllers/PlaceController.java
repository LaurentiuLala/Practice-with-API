package com.example.testofskills.Controllers;


import com.example.testofskills.DTO.PlaceDTO;
import com.example.testofskills.DTO.PlaceupdateDTO;
import com.example.testofskills.Service.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class PlaceController {

private final PlaceService placeService;

    @PostMapping("/places")
public ResponseEntity<?> Placeadd(@RequestBody PlaceDTO placeDTO){
        placeService.add(placeDTO);
        return ResponseEntity.ok(Map.of("message","PlaceAdded"));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> placeupdate(@PathVariable Long id, @RequestBody PlaceupdateDTO dto){
        return ResponseEntity.ok(placeService.placeupdate(id,dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getplacebyid(@PathVariable Long id){
        return ResponseEntity.ok(placeService.getplacebyid(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteplace(@PathVariable Long id){
        placeService.deleteplace(id);
        return ResponseEntity.ok(Map.of("message","Place deleted"));
    }
}
