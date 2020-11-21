package com.EarphoneModels.Controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.EarphoneModels.Entitys.BaseEntity;
import com.EarphoneModels.Exception.*;

public class BaseController<ENTITY extends BaseEntity, Repository extends JpaRepository<ENTITY, String>> {
    @Autowired
    private Repository repo;


    @GetMapping
    public List<ENTITY> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ENTITY getById(@PathVariable("id") String id) {
        return repo.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {
        repo.deleteById(id);
    }

    @PostMapping
    public ENTITY post(@RequestBody ENTITY entity) {
        if(repo.findById(entity.getId()).isPresent()) {
    		throw new RegistroDuplicadoException("Registro duplicado, j� existe um registro para esse identificador:" + entity.getId());
    	}
        repo.save(entity);
        return entity;
    }

    @PutMapping("/{id}")
    public ENTITY put(@PathVariable("id") String id, @RequestBody ENTITY entityUpdate) {
        if(!id.equals(entityUpdate.getId())) {
            System.out.println("aqui");
    		throw new IdsDiveregentesException("Identificador passado como parâmetro é diferente do identificador da entidade");
    	}
        Optional<ENTITY> entityBuscado = repo.findById(id);

    	if(entityBuscado.isPresent()) {
            return repo.save(entityUpdate);
        }else{
            throw new RegistroNãoEncontradoException("ID não encontrado");
        }

    }

}
