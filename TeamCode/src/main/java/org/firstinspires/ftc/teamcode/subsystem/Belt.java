package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Belt {

    private DcMotor belt;
    private double speed = 0.7;

    public Belt(DcMotor b) {
        belt = b;
    }

    public void setSpeed(double s) {
        speed = s;
    }

    public void forward() {
        belt.setPower(speed);
    }

    public void reverse() {
        belt.setPower(-speed);
    }

    public void stop() {
        belt.setPower(0);
    }

    public DcMotor getBelt() {
        return belt;
    }
}
