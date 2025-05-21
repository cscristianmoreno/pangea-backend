package com.backend.pangea.controllers.administrators;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.pangea.dto.HttpResponseEntity;
import com.backend.pangea.entity.Administrators;
import com.backend.pangea.models.controllers.administrators.IAdministratorController;
import com.backend.pangea.services.AdministratorRepositoryService;
import com.backend.pangea.utils.HttpResponseEntityUtil;

@Controller
@ResponseBody
@RequestMapping("/administrators")
public class AdministratorController implements IAdministratorController {

    private final AdministratorRepositoryService administratorRepositoryService;

    public AdministratorController(final AdministratorRepositoryService administratorRepositoryService) {
        this.administratorRepositoryService = administratorRepositoryService;
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Administrators>> save(Administrators entity) {
        Administrators result = administratorRepositoryService.save(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Administrators>> update(Administrators entity) {
        Administrators result = administratorRepositoryService.update(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Optional<Administrators>>> findById(int id) {
        Optional<Administrators> result = administratorRepositoryService.findById(id);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<List<Administrators>>> findAll() {
        List<Administrators> result = administratorRepositoryService.findAll();
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Void>> deleteById(int id) {
        administratorRepositoryService.deleteById(id);
        return HttpResponseEntityUtil.ok(null);
    }
    
}
