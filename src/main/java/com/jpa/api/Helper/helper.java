package com.jpa.api.Helper;

import com.jpa.api.Entity.testing;
import com.jpa.api.Repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class helper {
    @Autowired
    MyRepository crud;
    public List<testing> getUser ()
    {
        return (List<testing>) crud.findAll();
    }
    public testing GetUserById (int id )
    {
        return crud.findByUserId(id);
    }
    public testing saveData (testing u)
    {
        return crud.save(u);
    }
    public void deleteUserById (int id)
    {
        crud.deleteById(id);
    }
}
