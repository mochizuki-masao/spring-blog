package jp.classmethod.devio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mochizukimasao on 2017/10/26.
 *
 * @author mochizukimasao
 * @since version
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue
	@JsonProperty("book_id")
	private String bookId;
	
	@NonNull
	@JsonProperty("book_name")
	private String bookName;
	
	@NonNull
	@JsonProperty("author_name")
	private String authorName;
	
	@JsonProperty("user_id")
	private String userId;
}
