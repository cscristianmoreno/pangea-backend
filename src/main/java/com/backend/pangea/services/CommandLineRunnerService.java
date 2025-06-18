package com.backend.pangea.services;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("gh-action")
public class CommandLineRunnerService implements CommandLineRunner {
    
    @Override
    public void run(String... args) throws Exception {
        shutdown();
    }

    public void shutdown() {
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() {
            int seconds = 5;

            @Override
            public void run() {
                if (seconds == 0) {
                    timer.cancel();
                    System.out.println("Servidor detenido correctamente...");
                    System.exit(0);
                    return;
                }

                String message = String.format("Deteniendo servidor en %d...", seconds);
                System.out.println(message);
                seconds--;
            }
            
        }, 0, 1000);
    }
    
}
