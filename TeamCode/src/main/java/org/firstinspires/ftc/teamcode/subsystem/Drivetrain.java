package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drivetrain {

    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private double TICKS_PER_INCH = 1200 / (4 * Math.PI);
    private int fLTicks, fRTicks, bLTicks, bRTicks;
    private Telemetry telem;

    public Drivetrain(DcMotor fL, DcMotor fR, DcMotor bL, DcMotor bR) {
        frontLeft = fL;
        frontRight = fR;
        backLeft = bL;
        backRight = bR;

        init();
    }

    public void init() {
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void setTelemetry(Telemetry telemetry) {
        telem = telemetry;
    }

    public void useEncoders(boolean use) {
        if (use) {
            setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        } else {
            setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

    public void useBrake(boolean use) {
        if (use) {
            setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        } else {
            setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }
    }

    public void setMode(DcMotor.RunMode mode) {
        frontLeft.setMode(mode);
        frontRight.setMode(mode);
        backLeft.setMode(mode);
        backRight.setMode(mode);
    }

    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior zpb) {
        frontLeft.setZeroPowerBehavior(zpb);
        frontRight.setZeroPowerBehavior(zpb);
        backLeft.setZeroPowerBehavior(zpb);
        backRight.setZeroPowerBehavior(zpb);
    }

    public void setTargetPos(int fL, int fR, int bL, int bR) {
        frontLeft.setTargetPosition(fL);
        frontRight.setTargetPosition(fR);
        backLeft.setTargetPosition(bL);
        backRight.setTargetPosition(bR);
    }

    public void setBase(double fL, double fR, double bL, double bR) {
        setLeftSide(fL, bL);
        setRightSide(fR, bR);
    }

    public void setBase(double power) {
        setBase(power, power, power, power);
    }

    public void setLeftSide(double fL, double bL) {
        frontLeft.setPower(fL);
        backLeft.setPower(bL);
    }

    public void setLeftSide(double power) {
        setLeftSide(power, power);
    }

    public void setRightSide(double fR, double bR) {
        frontRight.setPower(fR);
        backRight.setPower(bR);
    }

    public void setRightSide(double power) {
        setRightSide(power, power);
    }

    public void forward(double power) {
        setBase(power);
    }

    public void reverse(double power) {
        setBase(-power);
    }

    public void pointTurnLeft(double power) {
        setBase(0, power, 0, power);
    }

    public void pointTurnRight(double power) {
        setBase(power, 0, power, 0);
    }

    public void pivotTurnLeft(double power) {
        setBase(-power, power, -power, power);
    }

    public void pivotTurnRight(double power) {
        setBase(power, -power, power, -power);
    }

    public void stop() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void drive(double fLInches, double fRInches, double bLInches, double bRInches,
                      double fLPower, double fRPower, double bLPower, double bRPower) {
        fLTicks = (int) (fLInches * TICKS_PER_INCH);
        fRTicks = (int) (fRInches * TICKS_PER_INCH);
        bLTicks = (int) (bLInches * TICKS_PER_INCH);
        bRTicks = (int) (bRInches * TICKS_PER_INCH);
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setTargetPos(fLTicks, fRTicks, bLTicks, bRTicks);
        setMode(DcMotor.RunMode.RUN_TO_POSITION);
        setBase(fLPower, fRPower, bLPower, bRPower);
        while (allBusy()) {
            telem.addData("fL", frontLeft.getCurrentPosition())
                    .addData("fR", frontRight.getCurrentPosition())
                    .addData("bL", backLeft.getCurrentPosition())
                    .addData("bR", backRight.getCurrentPosition())
                    .addData("fLTickGoal", fLTicks)
                    .addData("fRTickGoal", fRTicks)
                    .addData("bLTickGoal", bLTicks)
                    .addData("bRTickGoal", bRTicks);
            telem.update();
        }
        stop();
        setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public boolean allBusy() {
        return frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy();
    }

    public DcMotor getFrontLeft() {
        return frontLeft;
    }

    public DcMotor getFrontRight() {
        return frontRight;
    }

    public DcMotor getBackRight() {
        return backRight;
    }

    public DcMotor getBackLeft() {
        return backLeft;
    }
}
