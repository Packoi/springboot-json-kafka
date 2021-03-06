/**
 * 
 */
package com.packoi.json.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.packoi.json.domain.Status;
import com.packoi.json.service.KafkaService;

@RestController
@RequestMapping(path="api/proxy")
public class ProxyController {
	@Autowired
	private KafkaService kafkaService;

	
	@ResponseBody
	@RequestMapping("click")
	public Status Click(@RequestParam("iiid") int iiid,@RequestParam("total") int total) {
		 kafkaService.NewsClick(iiid, total);
		 return new Status(1,"ok");
	}
	@ResponseBody
	@RequestMapping("comment")
	public Status Comment(@RequestParam("plid") int plid,@RequestParam("total") int total) {
		kafkaService.NewsComment(plid, total);
		return new Status(1,"ok");
	}
}
