package com.example.meepmeeptesting;

import java.awt.image.BufferedImage;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(750);

        Pose2d startPose = new Pose2d(7, -63.75, Math.toRadians(-90));

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(45, 45, Math.toRadians(180), Math.toRadians(180), 17)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(startPose)
                                .lineToConstantHeading(new Vector2d(0, -33))
                                .waitSeconds(1)
                                .splineTo((new Vector2d(36, -36)), Math.toRadians(90))
                                .lineToConstantHeading(new Vector2d(36, -12))
                                .lineToConstantHeading(new Vector2d(44, -12))
                                .lineToConstantHeading(new Vector2d(44, -56))
                                .lineToConstantHeading(new Vector2d(62, -47))
                                .lineToConstantHeading(new Vector2d(62, -62))
                                //.lineToConstantHeading(new Vector2d(62, -47))
                                .lineToLinearHeading(new Pose2d(8, -33, Math.toRadians(-90)))
                                .splineTo((new Vector2d(36, -36)), Math.toRadians(90))
                                .lineToConstantHeading(new Vector2d(36, -12))
                                .lineToConstantHeading(new Vector2d(57, -12))
                                .lineToConstantHeading(new Vector2d(62, -56))
                                //.lineToLinearHeading(new Pose2d(62, -47, Math.toRadians(90)))
                                //.lineToConstantHeading(new Vector2d(62, -62))
                                //.lineToConstantHeading(new Vector2d(62, -47))
                                .lineToLinearHeading(new Pose2d(8, -33, Math.toRadians(-90)))
                                .lineToConstantHeading(new Vector2d(38, -62))
                                .build());

//                .setDarkMode(true)
//                .setBackgroundAlpha(0.95f)
//                .addEntity(myBot)
//                .start();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/Users/nwilliams25/Downloads/field-2024-juice-dark.png")); }
        catch (IOException e) {}

        meepMeep.setBackground(img)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}