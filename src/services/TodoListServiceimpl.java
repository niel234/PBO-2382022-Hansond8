package services;

import entities.TodoList;
import repositories.TodoListRepository;

public class TodoListServiceimpl implements TodoListService{
    private final TodoListRepository todoListRepository;

    public TodoListServiceimpl(final TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public TodoList[] getTodoList() {
        return todoListRepository.getAll();
    }

    @Override
    public void addTodoList(String todo) {
        if(todo.isEmpty() || todo.isBlank()) {
            System.out.println("Masukan todo dengan benar");
            return;
        }

        TodoList todoList = new TodoList();
        todoList.setTodo(todo);
        todoListRepository.add(todoList);

    }

    @Override
    public Boolean removeTodoList(final Integer number) {
        return todoListRepository.remove(number);
    }

    @Override
    public Boolean editTodoList(final Integer number, final String todo) {
        TodoList todoList = new TodoList();
        todoList.setTodo(todo);
        todoList.setId(number);
        return todoListRepository.edit(todoList);
    }
}