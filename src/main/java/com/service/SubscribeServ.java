/*This interface has a list of defined methods to make API calls to weather
 * and map */

package com.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.dto.WeatherDetailsDto;
import com.entity.Publisher;
import com.entity.Subscriber;
@Transactional
@Service
public interface SubscribeServ {
	List<Subscriber>  getTopic(int id);
	void  subscribe(Subscriber subscribe);
	List<Subscriber> findById(int subId);
	public List<Subscriber> findByTopic(String topic);
	public Subscriber findByTopicAndId(int subId,String topic);
	public void unSubscribe(Subscriber subscriber);
}
