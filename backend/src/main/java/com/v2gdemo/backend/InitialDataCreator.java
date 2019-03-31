package com.v2gdemo.backend;

import com.v2gdemo.backend.entity.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class InitialDataCreator implements ApplicationListener<ApplicationReadyEvent> {
    @NonNull
    private final CharacterRepository charRepository;

    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("42");
//        if (roleRepository.count() > 0) {
//            return;
//        }
//
//        roleRepository.save(new Role("ADMIN", java.util.UUID.randomUUID()));
    }
}