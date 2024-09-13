package com.epam.rd.autotasks.confbeans.video;

import java.time.LocalDateTime;

public class VideoStudioImp implements VideoStudio {

    private int number = 0;
    private int releaseDate = 1999;

    public VideoStudioImp() {

    }


    @Override
    public Video produce() {
        number++;
        releaseDate += 2;

        System.out.println("Cat & Curious " + number + " " + LocalDateTime.of(releaseDate, 10, 18, 10, 00));
        return new Video("Cat & Curious " + number, LocalDateTime.of(releaseDate, 10, 18, 10, 00));
    }


}