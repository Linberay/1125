package cn.edu.guet.bean;

import java.util.Objects;

public class Users {
    private int id;
    private String username;
    private String password;
    private String addtress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddtress() {
        return addtress;
    }

    public void setAddtress(String addtress) {
        this.addtress = addtress;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Objects.equals(username, users.username) && Objects.equals(password, users.password) && Objects.equals(addtress, users.addtress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, addtress);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", addtress='" + addtress + '\'' +
                '}';
    }

    public Users(int id, String username, String password, String addtress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.addtress = addtress;
    }

    public Users() {
    }

}
