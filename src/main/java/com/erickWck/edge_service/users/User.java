package com.erickWck.edge_service.users;

import java.util.List;

public record User(

        String username,
        String firstName,
        String lastName,
        List<String> roles
) {
}