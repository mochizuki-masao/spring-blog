package jp.classmethod.devio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by mochizukimasao on 2017/10/24.
 *
 * @author mochizukimasao
 * @since version
 */
@Getter
@Setter
public class User {
	
	@NotNull
	@JsonProperty("user_id")
	String userId;
	
	@NotNull
	String username;
}
