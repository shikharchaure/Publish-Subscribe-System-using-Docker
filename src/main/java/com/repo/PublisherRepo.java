/*This interface is used to write queries to Database*/
package com.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Publisher;
import com.entity.Subscriber;

@Transactional
@Repository
public interface PublisherRepo extends JpaRepository<Publisher,Integer>{
//Query for selecting Google response by start and end name from the database.
@Query("select p from Publisher as p where p.topic=:topic")
public List<Publisher> getResponseById(@Param("topic")String topic);

@Query("select p from Publisher as p where p.topic=:topic and p.createdAt>:createdAt")
public List<Publisher>  findByTopicAndTs(@Param("topic")String topic,@Param("createdAt")long ts);


@Query("select p from Publisher as p where p.publisherId=:publisherId and p.topic=:topic")
public Publisher findByTopicAndId(@Param("publisherId")int publisherId,@Param("topic")String topic);
	

}
	
