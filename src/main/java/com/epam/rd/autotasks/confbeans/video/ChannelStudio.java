package com.epam.rd.autotasks.confbeans.video;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ChannelStudio extends Channel {

    private List<Video> videos = new ArrayList<>();

    @Override
    public void addVideo(Video video) {
        videos.add(video);
    }


    @Override
    public Stream<Video> videos() {
        List<Video> copyVideos = new ArrayList<>();
        copyVideos.addAll(videos);
        Stream<Video> weeklyVideos = copyVideos.stream();

        System.out.println("\n");
        System.out.println(videos.toString());
        System.out.println("length of original video list " + videos.size());

        System.out.println("length of copyList " + copyVideos.size());

        Iterator<Video> it = videos.iterator();

        for (int i = 0; i < 7; i++) {
            if (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        System.out.println("After removal of weekly videos, size of videos: " + videos.size());

        return weeklyVideos;
    }


}