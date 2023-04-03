package hello;

import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandLineBean {

	// 어플리케이션 구동 시, 스프링부트가 ApplicationArguments의 구현체를 빈으로 등록해둔다.
	// 어플리케인션에서 전역적으로 사용할 수 있다.
	private final ApplicationArguments arguments;

	public CommandLineBean(ApplicationArguments arguments) {
		this.arguments = arguments;
	}

	@PostConstruct
	public void init() {
		log.info("source {}", List.of(arguments.getSourceArgs()));
		log.info("optionNames {}", arguments.getOptionNames());

		Set<String> optionNames = arguments.getOptionNames();
		for (String optionName : optionNames) {
			log.info("option args {}={}", optionName, arguments.getOptionValues(optionName));
		}
	}
}
