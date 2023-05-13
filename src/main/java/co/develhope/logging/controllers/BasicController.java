package co.develhope.logging.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping
    public String welcome(){
        logger.info("It is playing the welcome message");
        return "Welcome!";
    }
    @GetMapping("/exp")
    public int raiseToPower(@Value("${custom.n1}") int n1, @Value("${custom.n2}") int n2){
        logger.warn("He is about to perform a calculation");
        int result = n1;
        for (int i = 0; i < n2-1; i++) {
            result *= n1;
        }
        logger.warn("The result of the calculation is: "+ result);
        return result;
    }
    @GetMapping("/get-errors")
    public void getErrors(){
        logger.error("An error has been thrown");
    }


}