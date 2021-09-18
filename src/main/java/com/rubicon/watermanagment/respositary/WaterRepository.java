package com.rubicon.watermanagment.respositary;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rubicon.watermanagment.entity.Water;

@Repository
public interface WaterRepository extends PagingAndSortingRepository<Water, Long> {
	Optional<Water> findById(Long id);

}
