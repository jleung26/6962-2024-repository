package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.CustomTimer;
import org.firstinspires.ftc.teamcode.Subsystems.Mecanum;
import org.firstinspires.ftc.teamcode.Subsystems.ScoringArm;
import org.firstinspires.ftc.teamcode.Subsystems.VerticalSlides;

@TeleOp(name="Scoring Robot TeleOp", group="Active TeleOps")
public class ScoringRobotTeleOp extends OpMode {
    // creating subsystems
    private ScoringArm scoringArm = new ScoringArm();
    private Mecanum mecanumDrive = new Mecanum();
    private VerticalSlides vertSlides = new VerticalSlides();
    private CustomTimer timer = new CustomTimer();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        scoringArm.initialize(this, timer);
        mecanumDrive.initialize(this);
        vertSlides.initialize(this);
        telemetry.addLine("Gamepad 2: incrementals for tuning");
        telemetry.addLine("Left and Right Bumper - toggle claw open and close");
        telemetry.addLine("D-Pad Up and Down - incremental arm");
        telemetry.addLine("Left Joystick Y - incremental wrist turning");
        telemetry.addLine("Left Joystick X - incremental wrist rotation");
        telemetry.addLine("\nGamepad 1: set pos, only after gamepad 2 incrementals");
        telemetry.addLine("Right Bumper - claw toggle");
        telemetry.addLine("A - whole arm score position");
        telemetry.addLine("B - whole arm stow position");
        telemetry.addLine("X - whole arm transfer position");
        telemetry.update();
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */

    /*
     * allows driver to indicate that the IMU should not be reset
     * used when starting TeleOp after auto or if program crashes in the middle of match
     * relevant because of field-centric controls
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        scoringArm.operateTest();
        vertSlides.operateTest();
        mecanumDrive.operateFieldCentricTest();
        // Gamepad 2:
        // Left Bumper - incremental open claw
        // Right Bumper - incremental close claw
        // Left Joystick Y - wrist turn
        // Left Joystick X - wrist rotate
        // D-Pad Up - incremental arm up
        // D-Pad Down - incremental arm down

        // Gamepad 1:
        // right bumper - toggle claw
        // left trigger - past 0.7, score high bucket
        //                between 0.3 and 0.7, score high clip
        //                else, retract fully
        // Both Joysticks - regular field centric mecanum driving
        // dpad-left - toggle slow mode (buggy because refresh rate too high)
        // dpad-down - navx reset
        // A - arm preset to score clip
        // Y - arm preset to score bucket
        // B - arm preset to stow
        // X - arm preset to transfer

        telemetry.addData("Arm Transferring: ", scoringArm.arm.isArmTransferring);
        telemetry.addData("Claw Open: ", scoringArm.claw.isClawOpen);
        telemetry.addData("Wrist Transferring", scoringArm.wrist.isWristTransferring);
        telemetry.addData("Arm Pos: ", scoringArm.arm.telemetryArmPos());
        telemetry.addData("Wrist R Pos: ", scoringArm.wrist.telemetryWristRPos());
        telemetry.addData("Wrist L Pos: ",scoringArm.wrist.telemetryWristLPos());
        telemetry.update();
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        scoringArm.shutdown();
    }
}
