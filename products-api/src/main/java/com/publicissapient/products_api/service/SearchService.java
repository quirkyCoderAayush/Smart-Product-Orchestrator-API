package com.publicissapient.products_api.service;

import java.util.List;

import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.publicissapient.products_api.exception.SearchInitializationException;
import com.publicissapient.products_api.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchService {

	@PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void initializeHibernateSearch() {
        log.info("Initializing Hibernate Search indexes");
        try {
            SearchSession searchSession = Search.session(entityManager);
            searchSession.massIndexer()
                .threadsToLoadObjects(4)
                .batchSizeToLoadObjects(25)
                .startAndWait();
            log.info("Successfully initialized search indexes");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new SearchInitializationException("Failed to initialize search indexes", e);
        }
    }

    @Transactional(readOnly = true)
    public List<Product> fuzzySearch(String searchTerm) {
        SearchSession searchSession = Search.session(entityManager);
        return searchSession.search(Product.class)
            .where(f -> f.match()
                .fields("title", "description", "brand", "category", "sku")
                .matching(searchTerm)
                .fuzzy(2))
            .sort(f -> f.score())
            .fetchHits(20);
    }
}