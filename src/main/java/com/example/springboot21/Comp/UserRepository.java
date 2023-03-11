package com.example.springboot21.Comp;

import java.util.List;

@SuppressWarnings("unused")
public interface UserRepository {
    List<Authorities> getUserAuthorities(String user, String password);
}
