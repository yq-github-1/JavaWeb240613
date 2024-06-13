package edu.sandau.b230111.b23011111.controller;

import edu.sandau.b230111.b23011111.entity.User;
import edu.sandau.b230111.b23011111.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRespository;

    @RequestMapping("list")
    public String list(ModelMap map, User user) {
        if ("".equals(user.getName())){
            user.setName(null);
        }
        List<User> users = userRespository.findAll(Example.of(user));

        map.put("users", users);
        return "list";
    }

    @RequestMapping("/create")
    public String index_create(ModelMap model) {
        model.put("users", userRespository.findAll());
        return "create";
    }


    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userRespository.deleteById(id);
        return "redirect:/user/list";
    }

    @RequestMapping("save")
    public String save(User user) {
//        if(user.getId()==null||user.getId()==0){
//            user.setId(UUID.randomUUID());
//        }
        userRespository.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable Integer id, ModelMap map) {
        User user = userRespository.getById(id);
        map.put("user", user);
        map.put("users", userRespository.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(User userToUpdate, ModelMap map) {
        User user = userRespository.getById(userToUpdate.getId());
        user.setName(userToUpdate.getName().equals("") ? user.getName() : userToUpdate.getName());
        user.setAge(userToUpdate.getAge() != null ? userToUpdate.getAge() : user.getAge());
        userRespository.save(user);
        return "redirect:/user/list";
    }

}
