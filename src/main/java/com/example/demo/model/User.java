package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "role01")
    private String role01;

    @Column(name = "role02")
    private String role02;

    @Column(name = "role03")
    private String role03;

    @Column(name = "role04")
    private String role04;

    @Column(name = "role05")
    private String role05;

    @Column(name = "role06")
    private String role06;

    @Transient
    private List<String> roles = new ArrayList<String>();

    public List<String> getRoles() {
        // Get all fields of the class
        Field[] fields = getClass().getDeclaredFields();

        Map<String, String> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // Compare by keys
                return o1.compareTo(o2);
            }
        });


        // Iterate over each field
        for (Field field : fields) {
            try {
                // Get the field name
                String fieldName = field.getName();
                if (!fieldName.startsWith("role")) continue;

                // Get the field value
                Object value = field.get(this);

                if (value instanceof String) {
                    sortedMap.put(fieldName, (String) value);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sortedMap.values().stream().toList();
    }

    public void setRoles(List<String> roles) {
        // Get all fields of the class
        Field[] fields = getClass().getDeclaredFields();

//        Map<String, String> sortedMap = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                // Compare by keys
//                return o1.compareTo(o2);
//            }
//        });


        // Iterate over each field
        for (Field field : fields) {
            try {
                // Get the field name
                String fieldName = field.getName();
                if ( !fieldName.startsWith("role") || fieldName.equals("roles")) continue;
//                System.out.println(fieldName);
                int index = Integer.parseInt(fieldName.substring(4)) - 1;
                if (index < roles.size()) {
                    field.set(this, roles.get(index));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        return sortedMap.values().stream().toList();
    }
}
