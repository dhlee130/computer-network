package com.cclab.web.server;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cclab.web.server.domain.Member;
import com.cclab.web.server.repository.MemberRepository;

@SpringBootApplication
public class HTTP_Server {

    @Bean
    InitializingBean saveData(MemberRepository repo) {
        return () -> {
            repo.save(new Member("홍길동", 86, "960330-1306548"));
            repo.save(new Member("오영희", 48, "030702-4138926"));
            repo.save(new Member("김철수", 63, "050810-3306548"));
            repo.save(new Member("윤명숙", 43, "030302-2306548"));
            repo.save(new Member("이하나", 52, "980330-2306548"));
        };
    }
    
    
    

	public static void main(String[] args) {
		SpringApplication.run(HTTP_Server.class, args);
	}
}
