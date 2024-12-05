package com.example.shop1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class People {

    @Id
    private String name;

    private Integer age;

    public void addAge(){
        if(getAge() > 100){
            System.out.println("100살 넘기지 마세요");
            return;
        }
        this.age++;
    }

    public void changeAge(int age){
        if(age > 100 || age <0){
            System.out.println("나이 뻥치지 마세요");
            return;
        }
        this.age = age;
    }

}
