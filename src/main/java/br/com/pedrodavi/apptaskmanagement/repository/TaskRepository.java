package br.com.pedrodavi.apptaskmanagement.repository;

import br.com.pedrodavi.apptaskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
