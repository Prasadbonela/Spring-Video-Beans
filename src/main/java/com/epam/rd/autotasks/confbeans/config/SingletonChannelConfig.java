package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class SingletonChannelConfig {

    @Bean
    @Qualifier("video1")
    public Video video1() {
        return new Video("How to boil water", LocalDateTime.of(2020, 10, 10, 10, 10));
    }

    @Bean
    @Qualifier("video2")
    public Video video2() {
        return new Video("How to build a house", LocalDateTime.of(2020, 10, 10, 10, 11));
    }

    @Bean
    @Qualifier("video3")
    public Video video3() {
        return new Video("How to escape solitude", LocalDateTime.of(2020, 10, 10, 10, 12));
    }

    @Bean
    public Channel channel() {
        Channel channel = new Channel();
        channel.addVideo(video1());
        channel.addVideo(video2());
        channel.addVideo(video3());
        return channel;
    }
}