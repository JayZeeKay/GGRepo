package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {

    private Drivetrain drivetrain;
    private Intake intake;
    private Flywheel flywheel;
    private Belt belt;

    public Robot() {

    }

    public void init(HardwareMap hwMap, Telemetry telemetry) {
        drivetrain = new Drivetrain(hwMap.dcMotor.get("frontLeft"), hwMap.dcMotor.get("frontRight"), hwMap.dcMotor.get("backLeft"), hwMap.dcMotor.get("backRight"));
        intake = new Intake(hwMap.crservo.get("leftFlipper"), hwMap.crservo.get("rightFlipper"), hwMap.dcMotor.get("puller"));
        flywheel = new Flywheel(hwMap.dcMotor.get("leftFlywheel"), hwMap.dcMotor.get("rightFlywheel"));
        belt = new Belt(hwMap.dcMotor.get("Belt"));
    }

    public Drivetrain getDrivetrain() {
        return drivetrain;
    }

    public Intake getIntake() {
        return intake;
    }

    public Flywheel getFlywheel() {
        return flywheel;
    }

    public Belt getBelt() {
        return belt;
    }
}
