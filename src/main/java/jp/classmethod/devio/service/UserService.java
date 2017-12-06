package jp.classmethod.devio.service;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.classmethod.devio.configprops.DynamoDBConfigurationProperties;
import jp.classmethod.devio.model.Book;
import jp.classmethod.devio.model.BookRepository;
import jp.classmethod.devio.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mochizukimasao on 2017/10/24.
 *
 * @author mochizukimasao
 * @since version
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	
	@NonNull
	DynamoDB dynamoDB;
	
	@NonNull
	BookRepository bookRepository;
	
	@NonNull
	ObjectMapper objectMapper;
	
	@NonNull
	DynamoDBConfigurationProperties configprop;
	
	public User getUser(String userId) {
		try {
			Table table = dynamoDB.getTable(configprop.getTableName());
			Item item = table.getItem("user_id", userId);
			return objectMapper.convertValue(item.asMap(), User.class);
		} catch(Exception e) {
			log.error("getUser error.", e);
			throw e;
		}
	}
	
	public User registerUser(User user) {
		try {
			Table table = dynamoDB.getTable(configprop.getTableName());
			Item item = new Item().withPrimaryKey("user_id", user.getUserId())
				.withString("username", user.getUsername());
			table.putItem(new PutItemSpec().withItem(item));
			return user;
		} catch(Exception e) {
			log.error("registerUser error.", e);
			throw e;
		}
	}
	
	public List<Book> listBooks(String userId) {
		return bookRepository.findByUserId(userId);
	}
}
