package footballFields.service;

import footballFields.entities.LoginEntity;
import footballFields.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public List<LoginEntity> getAllLogin() {
        return loginRepository.findAll();
    }

    public Optional<LoginEntity> getLoginById(Long id) {
        return loginRepository.findById(id);

    }

    public LoginEntity saveLogin(LoginEntity user) {
        return loginRepository.save(user);
    }

    public LoginEntity updateLogin(LoginEntity login) {
        if(login == null) throw new NullPointerException("Compilare tutti i campi");

        Optional<LoginEntity> loginEntity = getLoginById(login.getId());

        if(loginEntity.isEmpty()) throw new NullPointerException();
        return loginRepository.save(login);
    }


    public void deleteLogin(Long id) {
        loginRepository.deleteById(id);
    }

    public List<String> getLoginByUserName(String userName) {

        return loginRepository.getLoginByUserName(userName);
    }
}
