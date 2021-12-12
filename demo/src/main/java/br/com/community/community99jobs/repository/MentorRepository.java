package br.com.community.community99jobs.repository;

import br.com.community.community99jobs.controller.MentorController;
import br.com.community.community99jobs.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
