package com.packoi.json.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.packoi.json.domain.Click;
import com.packoi.json.domain.Comment;
import com.packoi.json.util.KafkaJson;
import com.packoi.json.util.KafkaTools;

@Service
public class KafkaService {
	
	@Value("${click_topic}")
	private String click_topic;
	@Value("${comment_topic}")
	private String comment_topic;
	@Value("${kafka_address}")
	public String kafka_address;

	
	public void NewsClick(int iiid,int total){
		String msg = KafkaJson.getInstance().toJson(new Click(iiid, total));
		KafkaTools.getInstance(kafka_address).send(click_topic, msg);
	}
	
	public void NewsComment(int plid,int total){
		String msg = KafkaJson.getInstance().toJson(new Comment(plid, total));
		KafkaTools.getInstance(kafka_address).send(comment_topic, msg);
	}	
}
