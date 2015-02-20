package be.cronos.sinterklaas.repository;


import be.cronos.sinterklaas.domain.LetterEntity;

import java.util.List;

public interface LetterRepository {

    List<LetterEntity> getAll();

    LetterEntity getOne(Long id);

}
