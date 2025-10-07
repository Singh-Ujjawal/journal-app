package com.ujcompany.journalApp.repositery;

import com.ujcompany.journalApp.entity.ConfigJournalAppEntity;
import com.ujcompany.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId>  {

}
