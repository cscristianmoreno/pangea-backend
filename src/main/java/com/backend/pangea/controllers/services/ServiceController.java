package com.backend.pangea.controllers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.pangea.dto.HttpResponseEntity;
import com.backend.pangea.entity.Services;
import com.backend.pangea.models.controllers.services.IServiceController;
import com.backend.pangea.services.ServiceRepositoryService;
import com.backend.pangea.utils.HttpResponseEntityUtil;


@Controller
@ResponseBody
@RequestMapping("/services")
public class ServiceController implements IServiceController {

    private final ServiceRepositoryService serviceRepositoryService;

    public ServiceController(final ServiceRepositoryService serviceRepositoryService) {
        this.serviceRepositoryService = serviceRepositoryService;
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Services>> save(Services entity) {
        Services result = serviceRepositoryService.save(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Services>> update(Services entity) {
        Services result = serviceRepositoryService.update(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Optional<Services>>> findById(int id) {
        Optional<Services> result = serviceRepositoryService.findById(id);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<List<Services>>> findAll() {
        List<Services> result = serviceRepositoryService.findAll();
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Void>> deleteById(int id) {
        serviceRepositoryService.deleteById(id);
        return HttpResponseEntityUtil.ok(null);
    }
    
}
