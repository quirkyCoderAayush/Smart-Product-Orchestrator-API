package com.publicissapient.products_api.config;

import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateSearchConfig implements LuceneAnalysisConfigurer{
	
	@Override
    public void configure(LuceneAnalysisConfigurationContext context) {
        context.analyzer("english").custom()
            .tokenizer("standard")
            .tokenFilter("lowercase")
            .tokenFilter("stop")
            .tokenFilter("porterStem");
    }
}
