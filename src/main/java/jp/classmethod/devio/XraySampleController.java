package jp.classmethod.devio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mochizukimasao on 2017/10/24.
 *
 * @author mochizukimasao
 * @since version
 */
@RestController
public class XraySampleController {
	
	@GetMapping(path = "/")
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("OK");
	}
	
}
