package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class ChannelWithPhantomVideoStudioConfig {

    private int num = 0;
    private int releaseDate = 1999;

    @Bean
    @Scope("prototype")
    public Video video() {
        num++;
        releaseDate += 2;
        return new Video("Cat & Curious " + num, LocalDateTime.of(releaseDate, 10, 18, 10, 00));
    }

    @Bean
    public Channel channel() {
        Channel channel = new Channel();
        for (int i = 0; i < 8; i++) {
            Video video = video();
            channel.addVideo(video);
        }
        return channel;
    }
}