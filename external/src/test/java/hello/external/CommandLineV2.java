package hello.external;

import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

@Slf4j
public class CommandLineV2 {

	// --url=devdb --username=dev_user --password=dev_pw mode=on
	public static void main(String[] args) {
		// 커맨드 라인 옵션을 통해 인수를 key=value 형태로 가져올 수 있다.
		// 하나의 키에 여러가지 값을 지정할 수도 있다.

		// key=value 파싱이 안된 상태로 가져온다.
		for (String arg : args) {
			log.info("arg {}", arg);
		}

		// key=value 파싱을 위해 스프링에서 제공하는 객체
		ApplicationArguments appArgs = new DefaultApplicationArguments(args);
		// 파싱 안된 상태
		log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));
		// 옵션(--)이 없는 인수 mode=on
		log.info("NonOptionsArgs = {}", appArgs.getNonOptionArgs());
		// 옵션(--)있는 인수의 키 url, username, password
		log.info("OptionNames = {}", appArgs.getOptionNames());

		// 파싱된 상태로 출력
		Set<String> optionNames = appArgs.getOptionNames();
		for (String optionName : optionNames) {
			log.info("option arg {}={}", optionName, appArgs.getOptionValues(optionName));
		}

		List<String> url = appArgs.getOptionValues("url");
		List<String> username = appArgs.getOptionValues("username");
		List<String> password = appArgs.getOptionValues("password");
		List<String> mode = appArgs.getOptionValues("mode");
		log.info("url = {}", url);
		log.info("username = {}", username);
		log.info("password = {}", password);
		log.info("mode = {}", mode); // null
	}
}
