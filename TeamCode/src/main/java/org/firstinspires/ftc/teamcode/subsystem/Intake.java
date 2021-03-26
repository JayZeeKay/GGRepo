package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;

public class Intake {

    private CRServo leftFlipper, rightFlipper;
    private double speed;

    public Intake(CRServo lF, CRServo rF) {
        leftFlipper = lF;
        rightFlipper = rF;
    }

    public void flipIn() {
        leftFlipper.setPower(-speed);
        rightFlipper.setPower(speed);
    }

    public void flipOut() {
        leftFlipper.setPower(speed);
        rightFlipper.setPower(-speed);
    }

    public void stop() {
        leftFlipper.setPower(0);
        rightFlipper.setPower(0);
    }
}
