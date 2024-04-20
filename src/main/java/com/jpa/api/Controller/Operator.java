package com.jpa.api.Controller;

import com.jpa.api.Entity.testing;
import com.jpa.api.Helper.helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Component
public class Operator {
    @Autowired
    helper help;
    // Getting Data from Database
    @GetMapping("/user")
    public ResponseEntity<List<testing>> getUser ()
    {
        try {
            List<testing> list = help.getUser();
            if (list.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.of(Optional.of(list));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<testing> getUserById (@PathVariable("id") int id)
    {
        try {
            testing u = help.GetUserById(id);
            if (u == null)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.of(Optional.of(u));
        }
        catch(Exception e )
        {
            System.out.println(e.getMessage());
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Posting Data from Database
    @PostMapping("/user")
    public ResponseEntity<testing> postData (@RequestBody testing user)
    {
        try
        {
            testing one = help.saveData(user);
            if (one==null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok(user);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // deleting Data from Database via Id
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUserById (@PathVariable("id") int id)
    {
        try {
            help.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
