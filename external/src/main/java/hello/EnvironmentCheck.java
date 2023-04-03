package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnvironmentCheck {

	// 어플리케이션 구동 시, 스프링에서 구현체를 빈으로 등록해둔다.
	private final Environment env;

	public EnvironmentCheck(Environment env) {
		this.env = env;
	}

	// 자바 시스템 속성, 커맨드 라인 옵션 인수 모두 Environment를 통해 동일한 방법으로 읽을 수 있다.
	// 만약 자바 시스템 속성과 커맨드 라인 옵션 인수에 키가 중복되어 들어있다면, 커맨드 라인 옵션 인수가 우선권을 가진다.
	@PostConstruct
	public void init() {
		String url = env.getProperty("url");
		String username = env.getProperty("username");
		String password = env.getProperty("password");
		String numbers = env.getProperty("numbers");

		log.info("env url={}", url); // 커맨드 라인 옵션 인수, 중복
		log.info("env username={}", username); // 커맨드 라인 옵션 인수, 중복
		log.info("env password={}", password); // 커맨드 라인 옵션 인수, 중복
		log.info("env numbers={}", numbers); // 자바 시스템 속성, 중복 X
	}
}
