package com.fudan.ooad.repository;

import com.fudan.ooad.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by zihao on 2017/6/17.
 */
public interface TemplateRepository extends JpaRepository<Template, Integer> {
    Template findByTitle(String title);
    Template findByDescription(String description);
    Set<Template> findAllByTitleContainsOrDescriptionContains(String keyword);
}
