package com.iftm.exercicio02.data.vo;

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
    private List<Long> emailIds = new ArrayList<>();
    private List<Long> groupIds = new ArrayList<>();

    public UserVO() {
    }

    public UserVO(String firstName, String lastName, String userName, String password, String phone, String socialNetwork, List<Long> emailIds, List<Long> groupIds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.socialNetwork = socialNetwork;
        this.emailIds = emailIds;
        this.groupIds = groupIds;
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

    public List<Long> getEmailIds() {
        return emailIds;
    }

    public void setEmailIds(List<Long> emailIds) {
        this.emailIds = emailIds;
    }

    public List<Long> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<Long> groupIds) {
        this.groupIds = groupIds;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(id, userVO.id) && Objects.equals(firstName, userVO.firstName) && Objects.equals(lastName, userVO.lastName) && Objects.equals(userName, userVO.userName) && Objects.equals(password, userVO.password) && Objects.equals(phone, userVO.phone) && Objects.equals(socialNetwork, userVO.socialNetwork) && Objects.equals(emailIds, userVO.emailIds) && Objects.equals(groupIds, userVO.groupIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password, phone, socialNetwork, emailIds, groupIds);
    }

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
                ", emailIds=" + emailIds +
                ", groupIds=" + groupIds +
                '}';
    }
}

