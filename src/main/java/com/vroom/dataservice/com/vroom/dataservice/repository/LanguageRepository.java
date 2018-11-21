package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language,Long> {

    @Query("SELECT l FROM Language l WHERE (l.isdeleted = false OR l.isdeleted = 'false') ")
    List<Language> findAll();

    Language findById(int id);

    @Query("SELECT l FROM Language l WHERE l.language = :language and (l.isdeleted = false OR l.isdeleted = 'false') ")
    Language findByLanguage(@Param("language") String language);
}