package business;

import business.custom_exceptions.CustomNotFoundException;
import data.dtos.UserDto;
import data.entities.User;
import data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User save(UserDto userDto){
        var user = new User();
        user.setDni(userDto.getDni());
        user.setName(userDto.getName());
        return userRepository.save(user);
    }
    public User findOneById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) return userOptional.get();
        else throw new CustomNotFoundException("El usario con el id " + id + " no existe\n");
    }

}
