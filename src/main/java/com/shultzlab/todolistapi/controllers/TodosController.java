package com.shultzlab.todolistapi.controllers;

import com.shultzlab.todolistapi.models.Todo;
import com.shultzlab.todolistapi.repositories.TodoRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController()
@RequestMapping("/todo")
public class TodosController {
    final TodoRepository todoRepository;

    public TodosController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> getAllTodos(){
        return this.todoRepository.findAll();
    }

    @GetMapping("/owner/{owner}")
    public List<Todo> getAllTodosByOwner(@PathVariable(value = "owner") String owner) {
        return this.todoRepository.findAllByOwner(owner);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        Todo newTodo = this.todoRepository.save(todo);
        return newTodo;
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable(value = "id") Long id, @RequestBody Todo todo) {
        Todo updatedTodo = this.todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource with ID " + id));
        updatedTodo.setName(todo.getName());
        updatedTodo.setOwner(todo.getOwner());
        updatedTodo.setCompleted(todo.getCompleted());

        this.todoRepository.save(updatedTodo);

        return updatedTodo;
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteTodo(@PathVariable(value = "id") Long id) {
        Todo todoToDelete = this.todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource with ID " + id));

        this.todoRepository.delete(todoToDelete);

        Map<String, Boolean> response = new HashMap<>();
        response.put("success", true);

        return response;
    }
}
