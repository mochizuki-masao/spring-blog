package jp.classmethod.devio.eventlistener;

import com.amazonaws.xray.AWSXRay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by mochizukimasao on 2017/12/06.
 *
 * @author mochizukimasao
 * @since version
 */
@Component
@Slf4j
public class ContextStartupEventListener {

	@EventListener
	public void onStartupFinish(ContextRefreshedEvent event) {
		log.info("called!!!!");
		AWSXRay.endSegment();
	}
}
