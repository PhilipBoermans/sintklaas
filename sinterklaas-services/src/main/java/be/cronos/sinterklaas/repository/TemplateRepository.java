package be.cronos.sinterklaas.repository;

import be.cronos.sinterklaas.domain.TemplateEntity;

import java.util.List;

public interface TemplateRepository {

    List<TemplateEntity> getAll();

    TemplateEntity getOne(Long id);

}
