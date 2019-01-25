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
public interface SubscriberRepo extends JpaRepository<Subscriber,Integer>{
//Query for selecting Google response by start and end name from the database.
@Query("select s from Subscriber as s where s.subscriberId=:subscriberId")
public List<Subscriber> getResponseById(@Param("subscriberId")int subscriberId);


@Query("select s from Subscriber as s where s.topic=:topic")
public List<Subscriber> findByTopic(@Param("topic")String topic);

@Query("select s from Subscriber as s where s.subscriberId=:subscriberId and s.topic=:topic")
public Subscriber findByTopicAndId(@Param("subscriberId")int subscriberId,@Param("topic")String topic);


}
	
