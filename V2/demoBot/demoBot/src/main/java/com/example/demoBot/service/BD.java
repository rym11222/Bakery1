package com.example.demoBot.service;

//import com.example.demoBot.model.User;

//import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



//@Service
@Component
public class BD {


    @Autowired
    private UserRepository userRepository;
    

    public String registerUser(Long chatId, String[] Arr){

        if (userRepository.findById(chatId).isEmpty()){

            

            User user = new User();

            user.setChatId(chatId);
            user.setFirstName(Arr[1]);
            user.setLastName(Arr[2]);
            user.setPhoneNumber(Arr[3]);

            userRepository.save(user);

        }

        return "Регистрация прошла успешно";
    }


}
