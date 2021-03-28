package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@Disabled
@TeleOp (name = "ServoTest", group = "Test")
public class ServoTest extends LinearOpMode {

    Servo servo;

    @Override
    public void runOpMode() throws InterruptedException {
        servo = hardwareMap.servo.get("servo");
        telemetry.addData("How to Use", "Left trigger -> open. Right trgger -> close");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.left_trigger > .2) {
                servo.setPosition(180);
            } else if (gamepad1.right_trigger > .2) {
                servo.setPosition(0);
            }
            telemetry.addData("rT", gamepad1.right_trigger > 0.2);
            telemetry.addData("lT", gamepad1.left_trigger > 0.2);
            telemetry.addData("servo", servo.getPosition());
            telemetry.update();
        }
    }
}
