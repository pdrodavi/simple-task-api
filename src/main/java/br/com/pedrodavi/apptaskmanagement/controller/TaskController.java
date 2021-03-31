package br.com.pedrodavi.apptaskmanagement.controller;

import br.com.pedrodavi.apptaskmanagement.model.Task;
import br.com.pedrodavi.apptaskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task save(@RequestBody Task task) {
        return repository.save(task);
    }

    @GetMapping
    public List<Task> getAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Task getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return repository.findById(id).map(foundTask -> {
            Task updatedTask = Task.builder()
                    .id(foundTask.getId())
                    .titulo(task.getTitulo())
                    .descricao(task.getDescricao())
                    .responsavel(task.getResponsavel())
                    .prioridade(task.getPrioridade())
                    .data(task.getData())
                    .status(task.getStatus())
                    .build();
            return repository.save(updatedTask);
        }).orElseGet(() -> null);
    }

}
