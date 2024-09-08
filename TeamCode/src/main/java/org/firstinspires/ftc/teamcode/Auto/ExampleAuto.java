package org.firstinspires.ftc.teamcode.Auto;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Roadrunner.MecanumDrive;

@Config
@Autonomous(name = "Template Autoop", group = "16481-Example")
public class ExampleAuto extends LinearOpMode {

    // create subsystems
    private MecanumDrive drive; // roadrunner's mecanum drive subsystem

    @Override
    public void runOpMode() throws InterruptedException {
        // init()
        Pose2d startPose = new Pose2d(0, 0, Math.toRadians(0));

        drive = new MecanumDrive(hardwareMap, startPose);

//        DcMotor motor1 = hardwareMap.get(DcMotor.class,  "motor");

        // defining trajectories
        Action TrajectoryAction1 = drive.actionBuilder(drive.pose)
                .lineToX(10)
                .build();

        Action TrajectoryAction2 = drive.actionBuilder(new Pose2d(15,20,0))
                .splineTo(new Vector2d(5,5), Math.toRadians(90))
                .build();

        // init_loop()
        while(!isStarted() && !opModeIsActive()) {}

        // start()
        waitForStart();

        if (isStopRequested()) return;

        Actions.runBlocking(
                new SequentialAction(
                        TrajectoryAction1, // Example of a drive action

                        // This action and the following action do the same thing
                        new Action() {
                            @Override
                            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                                telemetry.addLine("Action!");
                                telemetry.update();
                                return false;
                            }
                        },
                        // Only that this action uses a Lambda expression to reduce complexity
                        (telemetryPacket) -> {
                            telemetry.addLine("Action!");
                            telemetry.update();
                            return false; // Returning true causes the action to run again, returning false causes it to cease
                        },
                        new ParallelAction( // several actions being run in parallel
                                TrajectoryAction2, // Run second trajectory
                                (telemetryPacket) -> { // Run some action
                                    //motor1.setPower(1);
                                    return false;
                                }
                        ),
                        drive.actionBuilder(new Pose2d(15,10,Math.toRadians(125))) // Another way of running a trajectory (not recommended because trajectories take time to build and will slow down your code, always try to build them beforehand)
                                .splineTo(new Vector2d(25, 15), 0)
                                .build()
                )
        );
    }
}