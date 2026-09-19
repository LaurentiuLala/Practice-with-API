package com.example.testofskills.DTO;

import com.example.testofskills.Models.Tags;

public record PlaceupdateDTO(

        String name,
   String address,
   String city,
   Tags tags,
   Integer rating
){}
