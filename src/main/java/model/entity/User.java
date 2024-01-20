package model.entity;

import com.github.javafaker.Faker;

/**
 * Пользователь, который хочет бургер
 */
public class User {
    String name;
    String login;
    String password;
    String email;

    public User(String name, String login, String password, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User() {
        Faker faker = new Faker();
        this.name = faker.name().firstName();
        this.login = faker.name().username();
        this.password = faker.crypto().sha256();
        this.email = faker.internet().emailAddress();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String toStringLogin() {
        return "{" +
                " \"password:\"" + password + '\"' +
                ", \"email:\"" + email + '\"' +
                '}';
    }

    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"password\":\"" + password + '\"' +
                ", \"email\":\"" + email + '\"' +
                '}';
    }
}
