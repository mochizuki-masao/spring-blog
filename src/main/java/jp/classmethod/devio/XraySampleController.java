package jp.classmethod.devio;

import jp.classmethod.devio.model.User;
import jp.classmethod.devio.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mochizukimasao on 2017/10/24.
 *
 * @author mochizukimasao
 * @since version
 */
@RestController
@RequiredArgsConstructor
public class XraySampleController {
	
	@NonNull
	UserService userService;
	
	@GetMapping(path = "/")
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("OK");
	}
	
	@GetMapping(path = "/users/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
		return ResponseEntity.ok(userService.getUser(userId));
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> registerUser(@RequestBody @Validated User user) {
		return ResponseEntity.ok(userService.registerUser(user));
	}
	
}
