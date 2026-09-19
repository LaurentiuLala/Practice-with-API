package com.example.testofskills.Service;

import com.example.testofskills.DTO.PlaceDTO;
import com.example.testofskills.DTO.PlaceupdateDTO;
import com.example.testofskills.Exceptions.PlaceNotFound;
import com.example.testofskills.Exceptions.RatingException;
import com.example.testofskills.Models.Place;
import com.example.testofskills.Repo.PlaceRepo;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class PlaceService
{
    private final PlaceRepo placerepository;

public PlaceDTO add(PlaceDTO dto){
    if(dto.rating() > 5){
       throw new RatingException("Rating too big");
    } else if(dto.rating() < 0){ throw new RatingException("Rating cannot be lower then 0");}

    Place place = Place.builder()
            .name(dto.name())
            .address(dto.address())
            .city(dto.city())
            .tags(dto.tags())
            .rating(dto.rating())
            .build();
    Place saved = placerepository.save(place);
return toDto(saved);
}

public PlaceDTO getplacebyid(Long id){

    Place place = placerepository.findById(id)
            .orElseThrow(() -> new PlaceNotFound("No such place exists"));

    return toDto(place);
}


public PlaceDTO placeupdate(Long id, PlaceupdateDTO dto){

    Place place = placerepository.findById(id)
            .orElseThrow(()-> new PlaceNotFound("No such place exists"));

    if(dto.address() != null) {place.setAddress(dto.address());}

    if(dto.name()!=null) {place.setName(dto.name());}

    if (dto.city() != null) {place.setCity(dto.city());}

    if(dto.tags() != null) {place.setTags(dto.tags());}



    if (dto.rating() != null){
     if(dto.rating() < 5 && dto.rating() > 0)
         place.setRating(dto.rating());
    }
    else throw new RatingException("Rating must be between 0 and 5");

Place updated = placerepository.save(place);

    return toDto(updated);

}

public void deleteplace(Long id){
    placerepository.findById(id)
            .orElseThrow(()-> new PlaceNotFound("No such place exists"));

    placerepository.deleteById(id);
}


private PlaceDTO toDto(Place place){
return PlaceDTO.builder()
        .id(place.getId())
        .name(place.getName())
        .address(place.getAddress())
        .city(place.getCity())
        .tags(place.getTags())
        .rating(place.getRating())
        .build();
}
}
