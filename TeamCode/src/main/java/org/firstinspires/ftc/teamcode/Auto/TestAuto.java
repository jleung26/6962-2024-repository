package org.firstinspires.ftc.teamcode.Auto;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Roadrunner.MecanumDrive;

@Config
@Autonomous(name = "Test Auto", group = "Test Autonomous")
public class TestAuto extends LinearOpMode{

    double startX = 0;
    double startY = 0;
    double startHeading = Math.toRadians(0);
    double scorePreloadX = 0;
    double scorePreloadY = 0;
    double pickupX = 0;
    double pickupY = 0;

    @Override
    public void runOpMode() {
        Pose2d startPose = new Pose2d(startX, startY, startHeading);
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose);

        TrajectoryActionBuilder move1 = drive.actionBuilder(startPose)
                .strafeTo(new Vector2d(scorePreloadX, scorePreloadY))
                .waitSeconds(3);

//        TrajectoryActionBuilder move2 = drive.actionBuilder(startPose) End of previous trajectory how?
//                .lineToYSplineHeading(pickupY, 0)
//                .waitSeconds(3);
    }
    
}