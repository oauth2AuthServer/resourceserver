package backend.joffre.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.joffre.dto.MessageDto;

@RestController
@RequestMapping("/resource")
public class ResourceController {

	@GetMapping("/user")
	@PreAuthorize("hasAnyAuthority('ROLE_USER', 'OIDC_USER')")
	public ResponseEntity<MessageDto> user(Authentication authentication) {
		return ResponseEntity.ok(new MessageDto("Hello " + authentication.getName()));
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<MessageDto> admin(Authentication authentication) {
		return ResponseEntity.ok(new MessageDto("Hello Mr. " + authentication.getName()));
	}
}
