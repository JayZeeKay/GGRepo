package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake {

    private CRServo leftFlipper, rightFlipper;
    private DcMotor puller;
    private double speed = 0.5;

    public Intake(CRServo lF, CRServo rF, DcMotor p) {
        leftFlipper = lF;
        rightFlipper = rF;
        puller = p;
    }

    public void flipIn() {
        leftFlipper.setPower(-speed);
        rightFlipper.setPower(speed);
    }

    public void flipOut() {
        leftFlipper.setPower(speed);
        rightFlipper.setPower(-speed);
    }

    public void pullIn() {
        puller.setPower(speed);
    }

    public void pushOut() {
        puller.setPower(-speed);
    }

    public void stopServos() {
        leftFlipper.setPower(0);
        rightFlipper.setPower(0);
    }

    public void stopMotor() {
        puller.setPower(0);
    }
}
