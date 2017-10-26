package jp.classmethod.devio.model;

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
	String id;
	
	@NotNull
	String name;
}
