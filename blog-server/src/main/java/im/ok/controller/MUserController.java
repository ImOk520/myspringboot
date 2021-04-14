package im.ok.controller;


import im.ok.service.IMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author imok
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/m-user")
public class MUserController {

    private IMUserService userService;

    @Autowired
    public void MUserController (IMUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Object test(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

}
