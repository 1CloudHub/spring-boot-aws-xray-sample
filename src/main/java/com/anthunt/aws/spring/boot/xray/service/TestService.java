package com.anthunt.aws.spring.boot.xray.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.xray.interceptors.TracingInterceptor;
import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.anthunt.aws.spring.boot.xray.dao.TestMapper;
import com.anthunt.aws.spring.boot.xray.service.clients.TestClient;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Slf4j
@Service
@Transactional
@XRayEnabled
public class TestService {

	@Autowired
	private TestClient testClient;
	
	public void test() {
		try {
		Thread.sleep(29000);
		}
		catch(Exception e) {
			
		}
		testClient.getGoogle();		
		log.debug("Serviced");
	}
	
}
