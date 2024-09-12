package com.csc340.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@RestController
public class Controller {
    Map<Integer, Cat> catDatabase = new HashMap<>();

    @GetMapping("cat/all")
    public Collection<Cat> getAllCat(){
        if(catDatabase.isEmpty()){
            catDatabase.put(1, new Cat(123, 1200, 10));
        }
        return catDatabase.values();
    }

    @GetMapping("cat/{id}")
    public Cat getCatById(@PathVariable int id){
        return catDatabase.get(id);
    }

    @PostMapping("cat/create")
    public Object createCat(@RequestBody Cat cat){
        catDatabase.put(cat.getId(), cat);
        return catDatabase.values();

    }

    @DeleteMapping("cat/delete/{id}")
    public Object deleteCat(@PathVariable int id){
        catDatabase.remove(id);
        return catDatabase.values();
    }

}
