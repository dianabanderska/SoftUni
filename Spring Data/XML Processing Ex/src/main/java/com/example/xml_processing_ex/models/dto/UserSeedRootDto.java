package com.example.xml_processing_ex.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedRootDto {

    @XmlElement(name = "user")
    private List<UserSeedDto> users;

    public List<UserSeedDto> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public void setUsers(List<UserSeedDto> users) {
        this.users = users;
    }
}
