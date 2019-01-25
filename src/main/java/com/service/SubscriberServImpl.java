/*This interface has a list of implemented methods to make API calls to weather
 * and map */

package com.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.WeatherDetailsDto;
import com.entity.Publisher;
import com.entity.Subscriber;
import com.repo.PublisherRepo;
import com.repo.SubscriberRepo;
@Transactional
@Service
public class SubscriberServImpl implements SubscribeServ {

	@Autowired
	SubscriberRepo subscriberRepo;

	@Override
	public List<Subscriber> getTopic(int id) {
		// TODO Auto-generated method stub
		//Optional<Subscriber> p=subscriberRepo.findById(id);
		return subscriberRepo.getResponseById(id);
	}

	@Override
	public void subscribe(Subscriber subscribe) {
		// TODO Auto-generated method stub
		subscriberRepo.save(subscribe);
		
	}

	@Override
	public List<Subscriber> findById(int subId) {
		// TODO Auto-generated method stub
		return subscriberRepo.getResponseById(subId);
	}
	@Override
	public List<Subscriber> findByTopic(String topic) {
		// TODO Auto-generated method stub
		return subscriberRepo.findByTopic(topic);
	}

	@Override
	public void unSubscribe(Subscriber subscriber) {
		// TODO Auto-generated method stub
		subscriberRepo.delete(subscriber);
		
	}

	@Override
	public Subscriber findByTopicAndId(int subId, String topic) {
		// TODO Auto-generated method stub
		return subscriberRepo.findByTopicAndId(subId, topic);
		
	}
	

	
}