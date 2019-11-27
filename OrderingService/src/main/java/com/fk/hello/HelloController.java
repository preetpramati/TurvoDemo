package com.fk.hello;


import org.springframework.web.bind.annotation.RestController;

import com.fk.utils.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Hello World from Ordeing Service\n";
    }
    
    @RequestMapping("/hi")
    public String indexHi() {
        return "Hello World from Ordeing Service\n";
    }
    
    
    @Autowired
    Publisher publisher;
    
    @RequestMapping("/send")
    public String sendMessage(@RequestParam("msg") String msg){
       System.out.println("*****"+msg);
       for(int i =0; i<25;i++){
       publisher.produceMsg(msg);
       }
       return "Successfully Msg Sent";
    }
}
