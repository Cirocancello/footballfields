package footballFields.controller;

import footballFields.entities.AssociateEntity;
import footballFields.entities.LoginEntity;
import footballFields.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footballfields/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/get-allLogin")
    public List<LoginEntity> getAllLogin(){
        return loginService.getAllLogin();
    }

    @GetMapping("/get-by-id/{id}")
    public LoginEntity getLoginById(@PathVariable Long id){
        return loginService.getLoginById(id).get();
    }

    @PostMapping("/save")
    public LoginEntity saveLogin(@RequestBody LoginEntity user){
        return loginService.saveLogin(user);
    }

    @PutMapping("/update")
    public LoginEntity updateLogin(@RequestBody LoginEntity login){
        return loginService.updateLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLogin(@PathVariable Long id){

        loginService.deleteLogin(id);
    }

    //custom
    @GetMapping("/login-by-user_name/{user_name}")
    public List<String> getLoginByUserName(@PathVariable String userName){
        return loginService.getLoginByUserName(userName);
    }

}
