package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Flywheel {

    private DcMotor leftFlywheel;
    private DcMotor rightFlywheel;
    private double speed = 1;

    public Flywheel(DcMotor lF, DcMotor rF) {
        leftFlywheel = lF;
        rightFlywheel = rF;

        init();
    }

    public void init() {
        leftFlywheel.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFlywheel.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void setPower(double lP, double rP) {
        leftFlywheel.setPower(lP);
        rightFlywheel.setPower(rP);
    }

    public void setPower(double power) {
        setPower(power, power);
    }

    public void shoot(double power) {
        setPower(power);
    }

    public void shoot() {
        setPower(speed);
    }

    public void reverse(double power) {
        setPower(-power);
    }

    public void reverse() {
        setPower(speed);
    }

    public void setSpeed(double speed) {
        speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void stop() {
        leftFlywheel.setPower(0);
        rightFlywheel.setPower(0);
    }

    public DcMotor getLeftFlywheel() {
        return leftFlywheel;
    }

    public DcMotor getRightFlywheel() {
        return rightFlywheel;
    }
}
