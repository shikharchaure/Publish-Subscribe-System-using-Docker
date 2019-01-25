/*This class handles all the requests submitted by users*/


package com.sc.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Publisher;
import com.entity.Subscriber;
import com.repo.SubscriberRepo;
import com.service.PublishServ;
import com.service.SubscribeServ;



@Controller
public class HelloController {

	@Autowired
	PublishServ publishServ;

	@Autowired
	SubscribeServ subscribeServ;
	@Autowired
	SubscriberRepo subscriberRepo;
	/*@RequestMapping(value="/publish",method=RequestMethod.GET)
	String publish(ModelMap model) throws IOException {
		return "pubsub";
	}
	
	
	@RequestMapping(value="/publish",method=RequestMethod.POST)
	String publish(ModelMap model,@RequestParam String publisherId,
			@RequestParam String topic,
			@RequestParam String message,
			@RequestParam String subscriberId,
			@RequestParam String subscriberTopic,
			@RequestParam String subscriberId2,
			@RequestParam String buttonClick,
			@RequestParam String output
			) throws IOException {
		
		
		StringBuffer notification=new StringBuffer();
		String subsribeMsg = output;
		String publishMsg="";
		if(buttonClick.equals("Subscribe")){
			//insert into Subscribe table sId, Topic
			Subscriber subscriber=new Subscriber();
			subscriber.setSubscriberId(Integer.parseInt(subscriberId));
			subscriber.setTopic(subscriberTopic);
			long ts=System.currentTimeMillis();
			subscriber.setCreatedAt(ts);
			subscribeServ.subscribe(subscriber);
			subsribeMsg=subsribeMsg+ "\n"+"Subscriber "+subscriberId+" has subscribed to topic "+subscriberTopic;
		}
		else if(buttonClick.equals("Logs In")){
			publishMsg="";
			List<Subscriber> subscribers=subscriberRepo.getResponseById(Integer.parseInt(subscriberId2));
			byte[] msg;
			for(Subscriber subscriber:subscribers){
			}
			for(Subscriber subscriber:subscribers){
				List<Publisher> publishers=publishServ.findByTopicAndTs(subscriber.getTopic(),subscriber.getCreatedAt());
				System.out.println("  V********S "+publishers);
				for(Publisher publisher:publishers){
					if( Arrays.equals(subscriber.getMessage(), publisher.getMessage())==false){
							//notification.append("New notification from on topic "+ +"by publisher "+publisher.getPublisherId()+"\n");
						String dispMsg=new String(publisher.getMessage());
						notification.append("New notification on "+subscriber.getTopic() +" by Publisher "+publisher.getPublisherId()+
								" - "+dispMsg+"\n");
						List<Subscriber> subscriberToUpdate=subscribeServ.findById(Integer.parseInt(subscriberId2));
						System.out.println("subscriber******"+subscriberToUpdate);
						subscriber.setMessage(publisher.getMessage());
						//subscriber.setCreatedAt(ts);
						subscriber.setCreatedAt(System.currentTimeMillis());
						subscribeServ.subscribe(subscriber);
						for(Subscriber subscriber2:subscriberToUpdate){
							subscriber2.setMessage(publisher.getMessage());
							subscriber.setCreatedAt(System.currentTimeMillis());
							subscribeServ.subscribe(subscriber2);
						}
					}
				}
			}
			if(notification.length()==0)
				notification.append("No new Notifications");
		}
		else{

			Publisher publishToUpdate=publishServ.findByTopicAndId(Integer.parseInt(publisherId),topic);
			if(publishToUpdate==null){
				System.out.println("NULL");
				Publisher publisher=new Publisher();
				publisher.setPublisherId(Integer.parseInt(publisherId));
				publisher.setTopic(topic);
				publisher.setMessage(message.getBytes());
				long ts=System.currentTimeMillis();
				publisher.setCreatedAt(ts);
				publishServ.publish(publisher);
				publishMsg=publishMsg+"\nPublisher "+publisherId+" just published to topic "+topic;
			}
			else{
				System.out.println("not NULL");
				long ts=System.currentTimeMillis();
				publishToUpdate.setCreatedAt(ts);
				publishToUpdate.setMessage(message.getBytes());
				publishServ.publish(publishToUpdate);
			}
		}
		
		model.addAttribute("notification",notification);
		model.addAttribute("subscribe",subsribeMsg);
		model.addAttribute("publish",publishMsg);
		notification=new StringBuffer();
		return "pubsub";
	}
	
	*/
	@RequestMapping(value="/phase2",method=RequestMethod.GET)
	String publish2(ModelMap model) throws IOException {
		return "pubsub";
	}
	
	
	@RequestMapping(value="/phase2",method=RequestMethod.POST)
	String publish2(ModelMap model,@RequestParam String publisherId,
			@RequestParam String topic,
			@RequestParam String message,
			@RequestParam String subscriberId,
			@RequestParam String subscriberTopic,
			@RequestParam String subscriberId2,
			@RequestParam String buttonClick,
			@RequestParam String output
			) throws IOException {
		
		
		StringBuffer notification=new StringBuffer();
		String subsribeMsg = output;
		String publishMsg="";
		if(buttonClick.equals("Subscribe")){
			//insert into Subscribe table sId, Topic
			Subscriber subscriber=new Subscriber();
			subscriber.setSubscriberId(Integer.parseInt(subscriberId));
			subscriber.setTopic(subscriberTopic);
			long ts=System.currentTimeMillis();
			subscriber.setCreatedAt(ts);
			subscribeServ.subscribe(subscriber);
			subsribeMsg=subsribeMsg+ "\n"+"Subscriber "+subscriberId+" has subscribed to topic "+subscriberTopic;
		}
		else if(buttonClick.equals("UnSubscribe")){
			//insert into Subscribe table sId, Topic
			Subscriber subscriber=subscribeServ.findByTopicAndId(Integer.parseInt(subscriberId), subscriberTopic);
			if(subscriber!=null){
			subscribeServ.unSubscribe(subscriber);
			subsribeMsg=subsribeMsg+ "\n"+"Subscriber "+subscriberId+" has been unSubscribed from topic "+subscriberTopic;
			}
			else{
				subsribeMsg="No subscribers to UnSubscribe";
			}
		}
		else if(buttonClick.equals("Logs In")){
			publishMsg="";
			List<Subscriber> subscribers=subscriberRepo.getResponseById(Integer.parseInt(subscriberId2));
			byte[] msg;
			for(Subscriber subscriber:subscribers){
			}
			for(Subscriber subscriber:subscribers){
				List<Publisher> publishers=publishServ.findByTopicAndTs(subscriber.getTopic(),subscriber.getCreatedAt());
				for(Publisher publisher:publishers){
					if( Arrays.equals(subscriber.getMessage(), publisher.getMessage())==false){
							//notification.append("New notification from on topic "+ +"by publisher "+publisher.getPublisherId()+"\n");
						String dispMsg=new String(publisher.getMessage());
						notification.append("New notification on "+subscriber.getTopic() +" by Publisher "+publisher.getPublisherId()+
								" - "+dispMsg+"\n");
						List<Subscriber> subscriberToUpdate=subscribeServ.findById(Integer.parseInt(subscriberId2));
						subscriber.setMessage(publisher.getMessage());
						//subscriber.setCreatedAt(ts);
						subscriber.setCreatedAt(System.currentTimeMillis());
						subscribeServ.subscribe(subscriber);
						for(Subscriber subscriber2:subscriberToUpdate){
							subscriber2.setMessage(publisher.getMessage());
							subscriber.setCreatedAt(System.currentTimeMillis());
							subscribeServ.subscribe(subscriber2);
						}
					}
				}
			}
			if(notification.length()==0)
				notification.append("No new Notifications");
		}
		else{
			Publisher publishToUpdate=publishServ.findByTopicAndId(Integer.parseInt(publisherId),topic);
			if(publishToUpdate==null){
				Publisher publisher=new Publisher();
				publisher.setPublisherId(Integer.parseInt(publisherId));
				publisher.setTopic(topic);
				publisher.setMessage(message.getBytes());
				long ts=System.currentTimeMillis();
				publisher.setCreatedAt(ts);
				publishServ.publish(publisher);
				publishMsg=publishMsg+"\nPublisher "+publisherId+" just published to topic "+topic;
			}
			else{
				long ts=System.currentTimeMillis();
				publishToUpdate.setCreatedAt(ts);
				publishToUpdate.setMessage(message.getBytes());
				publishServ.publish(publishToUpdate);
				publishMsg=publishMsg+"\nPublisher "+publisherId+" just published to topic "+topic;
			}
		}
		
		model.addAttribute("notification",notification);
		model.addAttribute("subscribe",subsribeMsg);
		model.addAttribute("publish",publishMsg);
		notification=new StringBuffer();
		return "pubsub";
	}
	
	
}
