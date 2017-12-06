package jp.classmethod.devio.configprops;

import lombok.Data;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by mochizukimasao on 2017/10/25.
 *
 * @author mochizukimasao
 * @since version
 */
@Data
@Component
@ConfigurationProperties(prefix = "dynamodb")
public class DynamoDBConfigurationProperties {
	
	private String tableName;
	
	private String region;
	
}
