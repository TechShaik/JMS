package com.files.JMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailSenderServices emailSenderServices;

    @PostMapping("/send")
    public String sendEmail(@RequestBody User user) {
    	emailSenderServices.sendMail(user.getToMail(), user.getSubject(), user.getBody(),user);
		return "Mail sent successfully to :"+user.getToMail();
    }
    }