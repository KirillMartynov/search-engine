package engine.server.config;

import engine.server.dao.InMemorySearchDao;
import engine.server.dao.SearchDao;
import engine.server.service.MatchersFactory;
import engine.server.service.MatchersFactoryImpl;
import engine.server.service.SearchService;
import engine.server.service.SearchServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public SearchDao searchDao() {
        return new InMemorySearchDao();
    }

    @Bean
    public MatchersFactory matchersFactory() {
        return new MatchersFactoryImpl();
    }

    @Bean
    public SearchService searchService(SearchDao searchDao) {
        return new SearchServiceImpl(searchDao);
    }
}
