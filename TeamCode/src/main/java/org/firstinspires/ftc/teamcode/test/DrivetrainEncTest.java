package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Drivetrain;

@TeleOp (name = "DrivetrainEncTest", group = "Test")
public class DrivetrainEncTest extends LinearOpMode {

    Drivetrain drive;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drivetrain(hardwareMap.dcMotor.get("frontLeft"), hardwareMap.dcMotor.get("frontRight"), hardwareMap.dcMotor.get("backLeft"), hardwareMap.dcMotor.get("backRight"));
        drive.setTelemetry(telemetry);
        telemetry.addData("How to Use", "Should move 12 inches");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            drive.forward(12, 0.5);
            break;
        }
    }
}
