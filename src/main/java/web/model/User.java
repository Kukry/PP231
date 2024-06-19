package web.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть между 2 и 30 символами")
    @Pattern(regexp = "[a-zA-Zа-яА-Я]*", message = "Только буквы русского и английского алфавита")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 30, message = "Фамилия должна быть между 2 и 30 символами")
    @Pattern(regexp = "[a-zA-Zа-яА-Я]*", message = "Только буквы русского и английского алфавита")
    @Column(name = "surname")
    private String surname;

    @Min(value = 0, message = "Значение возраста должно быть не менее 0")
    @Column(name = "age")
    private int age;

    public User() {
    }

    public User(String name, String surname, int age) {
        this.age = age;
        this.surname = surname;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
