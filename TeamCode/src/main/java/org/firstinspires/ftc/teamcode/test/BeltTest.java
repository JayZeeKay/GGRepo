package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Belt;

@TeleOp (name = "BeltTest", group = "Test")
public class BeltTest extends LinearOpMode {

    Belt belt;
    @Override
    public void runOpMode() throws InterruptedException {
        belt = new Belt(hardwareMap.dcMotor.get("belt"));
        telemetry.addData("How to Use", "a/b to go forward/backwards");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad2.a) {
                belt.forward();
            } else if (gamepad2.b) {
                belt.reverse();
            } else {
                belt.stop();
            }
            telemetry.addData("belt", belt.getBelt().getPower());
            telemetry.update();
        }
    }
}
