package com.exercicio2.exercicio2.data.vo;

import com.exercicio2.exercicio2.models.Email;
import com.exercicio2.exercicio2.models.User;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserVO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phone;
    private String socialNetwork;

    public UserVO() {}

    public UserVO(String firstName, String lastName, String userName, String password, String phone, String socialNetwork) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.socialNetwork = socialNetwork;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> user = new ArrayList<>();

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", socialNetwork='" + socialNetwork + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return id.equals(userVO.id) && firstName.equals(userVO.firstName) && lastName.equals(userVO.lastName) && userName.equals(userVO.userName) && password.equals(userVO.password) && phone.equals(userVO.phone) && socialNetwork.equals(userVO.socialNetwork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password, phone, socialNetwork);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
}
