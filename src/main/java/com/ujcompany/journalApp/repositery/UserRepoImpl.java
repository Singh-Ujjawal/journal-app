package com.ujcompany.journalApp.repositery;

import com.ujcompany.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepoImpl {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<User> getForSA() {
        Query  query = new Query();

//        query.addCriteria(Criteria.where("username").is("vipul"));

//        query.addCriteria(Criteria.where("email").exists(true));
//        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));

//        Criteria criteria = new Criteria();
//        criteria.andOperator(
//                Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"),
//                Criteria.where("sentimentAnalysis").is(true),
//                Criteria.where("username").is("ram")
//        );

        query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));

        List<User> list = mongoTemplate.find(query, User.class);
        return list;
    }
}
