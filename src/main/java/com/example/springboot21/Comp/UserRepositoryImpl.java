package com.example.springboot21.Comp;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl implements UserRepository {
    protected Map<User, List<Authorities>> map = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        var myUser = map.entrySet().stream()
                .filter(p -> p.getKey().getName().equals(user))
                .filter(p -> p.getKey().getPassword().equals(password))
                .findFirst();

        if (myUser.isPresent()) {
            return myUser.get().getValue();
        } else {
            return new ArrayList<>();
        }
    }
}
