package jp.classmethod.devio.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.classmethod.devio.configprops.DynamoDBConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * Created by mochizukimasao on 2017/10/24.
 *
 * @author mochizukimasao
 * @since version
 */
@Configuration
@Slf4j
public class XrayConfiguration {
	
	@Autowired
	DynamoDBConfigurationProperties configurationProperties;
	
	@Bean
	public FilterRegistrationBean awsxRayServletFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new AWSXRayServletFilter("xray-sample"));
		bean.setUrlPatterns(Collections.singleton("/*"));
		return bean;
	}

	/**
	 * DynamoDB Basic API Client
	 * @return 
	 */
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard()
			.withRegion(configurationProperties.getRegion())
			.build();
	}

	/**
	 * DynamoDB Document API
	 * @return
	 */
	@Bean
	public DynamoDB dynamoDB() {
		return new DynamoDB(amazonDynamoDB());
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
