package org.firstinspires.ftc.teamcode.Util;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.GyroEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.hardware.kauailabs.NavxMicroNavigationSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class RobotHardware {
    public HardwareMap hMap;

    public MotorEx leftFrontMotor = null;
    public MotorEx rightFrontMotor = null;
    public MotorEx leftBackMotor = null;
    public MotorEx rightBackMotor = null;

    public DcMotorEx vRslideMotor = null;
    public DcMotorEx vLslideMotor = null;

    public DcMotorEx hSlideMotor = null;

    public DcMotorEx intakeMotor = null;
    public Servo iWristServo = null;

    public Servo cWristServo = null, armServo = null, claw = null;

    //TODO: replace with OTOS
    public NavxMicroNavigationSensor navx;

    public GamepadEx gamepad1, gamepad2;

    //TODO: Replace with names in config
    public void init(@NonNull HardwareMap hardwareMap) {
        this.hMap = hardwareMap;

        navx = hMap.get(NavxMicroNavigationSensor.class, "navx");
        leftFrontMotor = new MotorEx(hMap, "Fl/Re");
        rightFrontMotor = new MotorEx(hMap, "Fr");
        leftBackMotor = new MotorEx(hMap, "Bl/Le");
        rightBackMotor = new MotorEx(hMap, "Br/Fe");
//                hMap.get(MotorEx.class, "Fl/Re");
//        rightFrontMotor = hMap.get(MotorEx.class, "Fr");
//        leftBackMotor = hMap.get(MotorEx.class, "Bl/Le");
//        rightBackMotor = hMap.get(MotorEx.class, "Br/Fe");

//        armServo = hMap.get(Servo.class, "");
//        cWristServo = hMap.get(Servo.class, "");
//        claw = hMap.get(Servo.class, "");
//
//        intakeMotor = hMap.get(DcMotorEx.class,"intake");
//        iWristServo = hMap.get(Servo.class, "");
//
//        hSlideMotor = hMap.get(DcMotorEx.class , "hSlide");
//
//        vRslideMotor = hMap.get(DcMotorEx.class, "vRslide");
//        vLslideMotor = hMap.get(DcMotorEx.class, "vLslide");
    }
}