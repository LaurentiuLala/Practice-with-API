package com.example.testofskills.DTO;

import com.example.testofskills.Models.Tags;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public record PlaceDTO
        (
                Long id,
@NotNull String name,
@NotNull String address,
@NotNull String city,
@NotNull Tags tags,
@NotNull Integer rating
        ){}

