package com.ujcompany.journalApp.repositery;

import com.ujcompany.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends MongoRepository<User, ObjectId>  {
    User findByUsername(String username) ;

    User deleteByUsername(String username);
}
