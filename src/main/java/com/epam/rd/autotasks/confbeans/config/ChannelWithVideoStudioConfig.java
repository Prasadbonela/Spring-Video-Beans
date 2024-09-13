package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.VideoStudio;
import com.epam.rd.autotasks.confbeans.video.VideoStudioImp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChannelWithVideoStudioConfig {

    @Bean
    @Qualifier("Cat & Curios")
    public VideoStudio videoStudio() {
        return new VideoStudioImp();
    }

    @Bean
    public Channel channel() {
        Channel channel = new Channel();
        for (int i = 0; i < 8; i++) {
            channel.addVideo(videoStudio().produce());
        }
        return channel;
    }
}