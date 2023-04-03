package hello.external;

import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaSystemProperties {

	public static void main(String[] args) {
		// 자바 시스템 속성 조회
		Properties properties = System.getProperties();
		for (Object key : properties.keySet()) {
			log.info("prop {}:{}", key, System.getProperty(String.valueOf(key)));
		}

		// 임의로 추가한 자바 시스템 속성, IDE VM에서 추가할 수 있다. 또는 jar 빌드 시 추가할 수 있다.
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");

		log.info("url={}", url);
		log.info("username={}", username);
		log.info("password={}", password);

		// 또는 자바 코드를 통해 자바 시스템 속성을 추가할 수도 있다.
		// 그러나 외부로 설정을 분리하는 의미가 사라진다.
		System.setProperty("hello_key", "hello_value");
		String hello_key = System.getProperty("hello_key");
		log.info("hello_key={}", hello_key);
	}
}
