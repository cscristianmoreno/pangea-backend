package com.backend.pangea.controllers.consumers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.pangea.dto.HttpResponseEntity;
import com.backend.pangea.entity.Consumers;
import com.backend.pangea.entity.Users;
import com.backend.pangea.models.controllers.consumers.IConsumerController;
import com.backend.pangea.services.ConsumerRepositoryService;
import com.backend.pangea.utils.HttpResponseEntityUtil;

@Controller
@ResponseBody
@RequestMapping("/consumers")
public class ConsumerController implements IConsumerController {

    private final ConsumerRepositoryService consumerRepositoryService;

    public ConsumerController(final ConsumerRepositoryService consumerRepositoryService) {
        this.consumerRepositoryService = consumerRepositoryService;
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Consumers>> save(Consumers entity) {
        Consumers result = consumerRepositoryService.save(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Consumers>> update(Consumers entity) {
        Consumers result = consumerRepositoryService.update(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Optional<Consumers>>> findById(int id) {
        Optional<Consumers> result = consumerRepositoryService.findById(id);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<List<Consumers>>> findAll() {
        List<Consumers> result = consumerRepositoryService.findAll();
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Void>> deleteById(int id) {
        consumerRepositoryService.deleteById(id);
        return HttpResponseEntityUtil.ok(null);
    }
    
}
