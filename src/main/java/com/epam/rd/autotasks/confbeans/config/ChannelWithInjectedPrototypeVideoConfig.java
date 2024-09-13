package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.ChannelStudio;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class ChannelWithInjectedPrototypeVideoConfig {
    private LocalDateTime localDateTime = LocalDateTime.now();

    private LocalDateTime localDateTime2 = LocalDateTime.now();

    private int attempt = 0;

    @Bean
    @Scope("prototype")
    public Video video() {
        if(attempt>13 && attempt <20){
            attempt++;
            localDateTime2 = localDateTime2.plusDays(1);
            System.out.println("unwanted ones: ");
            return new Video("Cat Failure Compilation", localDateTime2);
        }else{
            localDateTime = localDateTime.plusDays(1);

            attempt++;
            System.out.println("Cat Failure Compilation " + localDateTime+" attempt "+attempt);
            return new Video("Cat Failure Compilation", localDateTime );

        }

    }

    @Bean
    public Channel channel() {
        ChannelStudio channelStudio = new ChannelStudio();

        for (int i = 0; i < 14; i++) {
            channelStudio.addVideo(video());
        }

        return channelStudio;
    }
}