package nl.walker.novi.thinkbox.controller;

import nl.walker.novi.thinkbox.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/all")
    public String allAccess() {
        return testService.generatePublicContent();
    }

    @GetMapping("/user")
    public String userAccess() {
        return testService.generateUserContent();
    }

    @GetMapping("/admin")
    public String adminAccess() {
        return testService.generateAdminContent();
    }
}

// dit moet eruit, testserice dat je iets krijgt