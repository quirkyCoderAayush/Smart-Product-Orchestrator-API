package com.publicissapient.products_api.config;

import org.hibernate.search.mapper.orm.Search;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class IndexingService {

	@PersistenceContext
	private EntityManager entityManager;

	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void doIndex() {
		log.info("Starting indexing...");
		try {
			Search.session(entityManager).massIndexer().startAndWait();
			log.info("Indexing completed successfully");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			log.error("Indexing interrupted", e);
		}
	}
}
