package com.wildcodeschool.wizards.springHibernatewizards.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wildcodeschool.wizards.springHibernatewizards.entities.User;
import com.wildcodeschool.wizards.springHibernatewizards.repositories.UserRepository;

@Component
public class Outputter implements CommandLineRunner {

	private Logger LOG = LoggerFactory.getLogger("Marthe");
   
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public void run(String... args) throws Exception {
		LOG.info("******************");
		LOG.info("Objects in DB : " + userRepository.count());

        User user1 = new User("Gandalf", "Sorcier", 1043);
        LOG.info("******************");
        LOG.info(user1 + " has been created !");
        userRepository.save(user1);
        LOG.info(user1 + " has been saved !");

        User user2 = new User("Cruella", "Sorcière", 256);
        LOG.info("******************");
        LOG.info(user2 + " has been created !");
        userRepository.save(user2);
        LOG.info(user2 + " has been saved !");

        User tempUser = userRepository.findById(2L).get(); 
        
        LOG.info("******************");
        LOG.info("Second user's firstName is " + tempUser.getFirstName());
        LOG.info("Second user's lastName is " + tempUser.getLastName());
        LOG.info("Second user's age is " + tempUser.getAge());

        LOG.info("******************");
        LOG.info("Users in list are ");
        for(User myUser : userRepository.findAll()) {
            LOG.info(myUser.toString());
        };

        userRepository.deleteById(2L); 
        
        LOG.info("******************");
        LOG.info("Users in list are ");
        for(User myUser : userRepository.findAll()) {
            LOG.info(myUser.toString());
        };
    }
}
