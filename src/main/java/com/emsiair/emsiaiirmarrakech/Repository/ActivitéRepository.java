package com.emsiair.emsiaiirmarrakech.Repository;

import com.emsiair.emsiaiirmarrakech.Model.Activité;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitéRepository extends JpaRepository<Activité, Long> {

}