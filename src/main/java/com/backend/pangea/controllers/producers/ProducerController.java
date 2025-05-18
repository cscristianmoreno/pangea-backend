package com.backend.pangea.controllers.producers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.pangea.dto.HttpResponseEntity;
import com.backend.pangea.entity.Producers;
import com.backend.pangea.models.controllers.producers.IProducerController;
import com.backend.pangea.services.ProducerRepositoryService;
import com.backend.pangea.utils.HttpResponseEntityUtil;

@Controller
@ResponseBody
@RequestMapping("/producers")
public class ProducerController implements IProducerController {

    private final ProducerRepositoryService producerRepositoryService;

    public ProducerController(final ProducerRepositoryService producerRepositoryService) {
        this.producerRepositoryService = producerRepositoryService;
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Producers>> save(Producers entity) {
        Producers result = producerRepositoryService.save(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Producers>> update(Producers entity) {
        Producers result = producerRepositoryService.update(entity);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Optional<Producers>>> findById(int id) {
        Optional<Producers> result = producerRepositoryService.findById(id);
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<List<Producers>>> findAll() {
        List<Producers> result = producerRepositoryService.findAll();
        return HttpResponseEntityUtil.ok(result);
    }

    @Override
    public ResponseEntity<HttpResponseEntity<Void>> deleteById(int id) {
        producerRepositoryService.deleteById(id);
        return HttpResponseEntityUtil.ok(null);
    }
    
}
