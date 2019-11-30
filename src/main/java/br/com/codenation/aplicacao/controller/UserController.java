package br.com.codenation.aplicacao.controller;

import br.com.codenation.aplicacao.domain.vo.UserVO;
import br.com.codenation.aplicacao.service.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/updateName")
    public UserVO updateUserName(@RequestBody UserVO user){
        return userService.updateNameUserById(user.getId(), user.getName());
    }

    @PutMapping("/updateCompany")
    public void updateCompanyByUserId(@RequestParam("id") Long id, @RequestParam("companyId") Long companyId){
        userService.updateCompanyByUserId(id, companyId);
//        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public void deleteById(@Param("id") Long id){
        userService.deleteUser(id);
    }

//
//    public void createUser(String name, String document, int age, String login, String password, Long idCompany, BigDecimal salary){
//        userService.createUser(name,document,age,login,password,idCompany,salary);
//    }
//
//    public void deleteUser(){
//
//    }

}
