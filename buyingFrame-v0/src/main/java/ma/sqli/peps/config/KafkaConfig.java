package ma.sqli.peps.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    public static final String BUYING_FRAME_V_2 = "buying-frame-v2";

    @Bean
    public NewTopic createTopic(){
        return new NewTopic(BUYING_FRAME_V_2,5, (short) 1);
    }
}
