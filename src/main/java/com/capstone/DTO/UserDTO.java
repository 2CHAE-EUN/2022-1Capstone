package com.capstone.DTO;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Component
public class UserDTO implements UserDetails {

    private int num;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userBirYear;
    private String userBirMonth;
    private String userBirDay;
    private String userBirth;
    private String userGender;
    private String userSignUpDate;
    private String userAuth;

    public UserDTO(){}

    public UserDTO(int num, String userEmail, String userPassword, String userName, String userBirYear, String userBirMonth, String userBirDay, String userBirth, String userGender, String userSignUpDate, String userAuth, List<String> assetList) {
        this.num = num;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userBirYear = userBirYear;
        this.userBirMonth = userBirMonth;
        this.userBirDay = userBirDay;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.userSignUpDate = userSignUpDate;
        this.userAuth = userAuth;

    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirYear() {
        return userBirYear;
    }

    public void setUserBirYear(String userBirYear) {
        this.userBirYear = userBirYear;
    }

    public String getUserBirMonth() {
        return userBirMonth;
    }

    public void setUserBirMonth(String userBirMonth) {
        this.userBirMonth = userBirMonth;
    }

    public String getUserBirDay() {
        return userBirDay;
    }

    public void setUserBirDay(String userBirDay) {
        this.userBirDay = userBirDay;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserSignUpDate() {
        return userSignUpDate;
    }

    public void setUserSignUpDate(String userSignUpDate) {
        this.userSignUpDate = userSignUpDate;
    }

    public String getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(String userAuth) {
        this.userAuth = userAuth;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
