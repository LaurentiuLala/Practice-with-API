package com.example.testofskills.Repo;

import com.example.testofskills.Models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepo extends JpaRepository<Place, String>
{

}
