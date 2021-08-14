package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * データの一覧を返す
     * @return
     */
    public List<Person> findAll() {

        // 実行するSQLを組み立てて実行
        String query = "SELECT * FROM person";
        List<Person> persons = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class));

        return persons;
    }

    public Person save(Person person) {

        // 実行するSQLを組み立てる
        SqlParameterSource param = new BeanPropertySqlParameterSource(person);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("person")
                .usingGeneratedKeyColumns("id");

        // SQLを実行して、AUTO_INCREMENTの値を取得する
        Number key = insert.executeAndReturnKey(param);
        person.setId(key.longValue());

        log.info("Add: " + person);

        return person;
    }
}