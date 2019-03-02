package com.despegar.cgp.web;

import com.despegar.cgp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
public class UsersController {

    private List<User> users;

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    public UsersController() {
        this.users = new ArrayList<User>();
        this.users.add(new User("1", "Dwight Schrute", "cloud"));
        this.users.add(new User("2", "Jim Halpert", "plataforma"));
        this.users.add(new User("3", "Roberto California", "fulfillment"));
        this.users.add(new User("4", "Michael Scott", "aftersale"));
        this.users.add(new User("5", "Andy Bernard", "cfa"));
        this.users.add(new User("6", "Pam Halpert", "shopping"));
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> list() {
        logger.debug("Retrieving all users...");
        return this.users;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> getUserById(@PathVariable("id") String id) {
        logger.debug("Retrieving user with id {}...", id);
        return this.users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

}
