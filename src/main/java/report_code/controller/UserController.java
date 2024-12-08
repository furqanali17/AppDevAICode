package report_code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import report_code.entity.User;
import report_code.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}/password")
    public User updateUserPassword(@PathVariable Long id, @RequestBody String newPassword) {
        return userService.updateUserPassword(id, newPassword);
    }

    @PutMapping("/{id}/toggle-unlocked")
    public User toggleUserUnlocked(@PathVariable Long id) {
        return userService.toggleUserUnlocked(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
