package com.iftm.exercicio02.data.vo;

import java.io.Serializable;
import java.util.Objects;

public class GroupVO implements Serializable {

    private Long id;
    private String name;
    private String description;

    public GroupVO() {
    }

    public GroupVO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupVO groupVO = (GroupVO) o;
        return Objects.equals(id, groupVO.id) && Objects.equals(name, groupVO.name) && Objects.equals(description, groupVO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "GroupVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
