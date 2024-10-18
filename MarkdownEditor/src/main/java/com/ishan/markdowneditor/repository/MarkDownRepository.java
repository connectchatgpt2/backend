package com.ishan.markdowneditor.repository;

import com.ishan.markdowneditor.entity.MarkDown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkDownRepository extends JpaRepository<MarkDown, String> {

}
