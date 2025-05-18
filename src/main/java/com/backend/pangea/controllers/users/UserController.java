package com.backend.pangea.controllers.users;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.pangea.dto.HttpResponseEntity;
import com.backend.pangea.entity.Users;
import com.backend.pangea.models.controllers.users.IUserController;
import com.backend.pangea.services.UserRepositoryService;
import com.backend.pangea.utils.HttpResponseEntityUtil;

@Controller
@ResponseBody
@RequestMapping("/users")
public class UserController implements IUserController {

    private final UserRepositoryService userRepositoryService;

    public UserController(final UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Users>> save(Users entity) {
        Users result = userRepositoryService.save(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Users>> update(Users entity) {
        Users result = userRepositoryService.update(entity);
        return HttpResponseEntityUtil.ok(result);
    }   

    @Override
    public ResponseEntity<HttpResponseEntity<Optional<Users>>> findById(int id) {
        Optional<Users> result = userRepositoryService.findById(id);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<List<Users>>> findAll() {
        List<Users> result = userRepositoryService.findAll();
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Void>> deleteById(int id) {
        userRepositoryService.deleteById(id);
        return HttpResponseEntityUtil.ok(null);
    }
    
}
