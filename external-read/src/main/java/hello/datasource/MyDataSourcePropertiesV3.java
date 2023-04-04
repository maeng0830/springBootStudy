package hello.datasource;

import java.time.Duration;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

@Getter
@ConfigurationProperties("my.datasource")
@Validated
public class MyDataSourcePropertiesV3 {

	@NotEmpty
	private String url;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private Etc etc;

	@ConstructorBinding
	public MyDataSourcePropertiesV3(String url, String username, String password, Etc etc) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.etc = etc;
	}

	@Getter
	public static class Etc {
		@Min(1) @Max(999)
		private int maxConnection;
		@DurationMin(seconds = 1)
		@DurationMax(seconds = 60)
		private Duration timeout;
		private List<String> options;

		@ConstructorBinding
		public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT") List<String> options) {
			this.maxConnection = maxConnection;
			this.timeout = timeout;
			this.options = options;
		}
	}
}
