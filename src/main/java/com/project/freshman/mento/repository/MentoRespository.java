package com.project.freshman.mento.repository;

import com.project.freshman.mento.model.Mento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentoRespository extends JpaRepository<Mento, Long> {
    public Optional<Mento> findByMentoEmail(String mentoEmail);
}
