/*This interface has a list of defined methods to make API calls to weather
 * and map */

package com.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.dto.WeatherDetailsDto;
import com.entity.Publisher;
@Transactional
@Service
public interface PublishServ {
	List<Publisher>  getTopic(String topic);
	void  publish(Publisher publisher);
	List<Publisher> findByTopicAndTs(String topic,long id);
	 Publisher findByTopicAndId(int id,String topic);
}
