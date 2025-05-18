package com.backend.pangea.controllers.municipes;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.pangea.dto.HttpResponseEntity;
import com.backend.pangea.entity.Municipes;
import com.backend.pangea.models.controllers.municipes.IMunicipeController;
import com.backend.pangea.services.MunicipeRepositoryService;
import com.backend.pangea.utils.HttpResponseEntityUtil;

@Controller
@ResponseBody
@RequestMapping("/municipes")
public class MunicipeController implements IMunicipeController {

    private final MunicipeRepositoryService municipeRepositoryService;

    public MunicipeController(final MunicipeRepositoryService municipeRepositoryService) {
        this.municipeRepositoryService = municipeRepositoryService;
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Municipes>> save(Municipes entity) {
        Municipes result = municipeRepositoryService.save(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Municipes>> update(Municipes entity) {
        Municipes result = municipeRepositoryService.update(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Optional<Municipes>>> findById(int id) {
        Optional<Municipes> result = municipeRepositoryService.findById(id);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<List<Municipes>>> findAll() {
        List<Municipes> result = municipeRepositoryService.findAll();
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Void>> deleteById(int id) {
        municipeRepositoryService.deleteById(id);
        return HttpResponseEntityUtil.ok(null);
    }
    
}
