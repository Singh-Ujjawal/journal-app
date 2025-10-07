package com.ujcompany.journalApp.cache;

import com.ujcompany.journalApp.entity.ConfigJournalAppEntity;
import com.ujcompany.journalApp.repositery.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String,String> APP_CACHE ;

    @PostConstruct
    public void init() {
        APP_CACHE = new HashMap<>();
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
        all.forEach(configJournalAppEntity -> {
            APP_CACHE.put(configJournalAppEntity.getKey(),configJournalAppEntity.getValue());
        });
    }
}
