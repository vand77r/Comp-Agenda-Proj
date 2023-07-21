package com.in28minutes.rest.webservices.resfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
	private static List<Todos> todos = new ArrayList();
	private static long id=0;
	
	static {
		todos.add(new Todos(++id, "vLove", "Dance", new Date(), false));
		todos.add(new Todos(++id, "vLove", "Angular", new Date(), false));
		todos.add(new Todos(++id, "vLove", "Python", new Date(), false));
		todos.add(new Todos(++id, "vLove", "Faang", new Date(), false));
	}
	
	public List<Todos> findAll(){
		return todos;
	}
	
	public Todos save(Todos todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++id);
			todos.add(todo);
		}else {
			deleteTodo(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todos deleteTodo(long id) {
		Todos todo = findById(id);
		if(todo == null) 
			return null;
		if(todos.remove(todo)) 
			return todo;
		return null;
	}

	public Todos findById(long id2) {
		for(Todos todo: todos) {
			if(todo.getId() == id2) {
				return todo;
			}
		}
		return null;
	}

}
