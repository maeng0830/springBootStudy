package hello.external;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandLineV1 {

	public static void main(String[] args) {
		// 커맨드 라인 인수 조회
		// IDE arguments에서 추가할 수 있다. 또는 jar 빌드 시 추가할 수 있다.
		// key=value 형식으로 넘어오지 않기 때문에 추가로 파싱해야한다는 단점이 있다.
		for (String arg : args) {
			log.info("arg {}", arg);
		}
	}
}
