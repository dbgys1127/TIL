package hello1.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
    /**
     * GET/mapping/users
     */
    @GetMapping
    public String users(){
        return "get users";
    }
    /**
     * POST/mapping/users
     */
    @PostMapping
    public String addUser(){
        return "post user";
    }

    /**
     * GET/mapping/users/{userID}
     */
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return "get userId=" + userId;
    }
    /**
     * PATCH/mapping/users/{userID}
     */
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId){
        return "update userId="+userId;
    }
    /**
     * DELETE/mapping/users/{userID}
     */
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "delede userId="+userId;
    }
}
