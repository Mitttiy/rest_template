package org.example.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private String lastName;

    private Byte age;
}

