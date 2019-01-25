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
import com.repo.PublisherRepo;
@Transactional
@Service
public class PublishServImpl implements PublishServ {

	@Autowired
	PublisherRepo publishRepo;

	@Override
	public List<Publisher> getTopic(String topic) {
		// TODO Auto-generated method stub
		List<Publisher> p=publishRepo.getResponseById(topic);
		return p;
	}

	@Override
	public void publish(Publisher publisher) {
		// TODO Auto-generated method stub
		publishRepo.save(publisher);
	}

	@Override
	public List<Publisher> findByTopicAndTs(String topic, long ts) {
		// TODO Auto-generated method stub
		return publishRepo.findByTopicAndTs(topic, ts);
	}
	@Override
	public Publisher findByTopicAndId(int id, String topic) {
		// TODO Auto-generated method stub
		return  publishRepo.findByTopicAndId(id, topic);
	}

	
}