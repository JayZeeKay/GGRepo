package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Drivetrain;

@Disabled
@TeleOp (name ="DrivetrainTest", group = "Test")
public class DrivetrainTest extends LinearOpMode {

    public Drivetrain drive;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drivetrain(hardwareMap.dcMotor.get("frontLeft"), hardwareMap.dcMotor.get("frontRight"), hardwareMap.dcMotor.get("backLeft"), hardwareMap.dcMotor.get("backRight"));
        telemetry.addData("How to Use", "Tank Drive. Use sticks to drive");
        telemetry.update();
        waitForStart();
        while(opModeIsActive()) {
            if (Math.abs(gamepad1.right_stick_y) > .2) {
                drive.setRightSide(-gamepad1.right_stick_y);
            } else {
                drive.setRightSide(0);
            }
            if (Math.abs(gamepad1.left_stick_y) > .2) {
                drive.setLeftSide(-gamepad1.left_stick_y);
            } else {
                drive.setLeftSide(0);
            }
        }
    }
}
