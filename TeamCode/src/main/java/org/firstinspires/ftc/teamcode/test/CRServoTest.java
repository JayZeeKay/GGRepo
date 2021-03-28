package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp (name = "CRServoTest", group = "Test")
public class CRServoTest extends LinearOpMode {

    CRServo servo;

    @Override
    public void runOpMode() throws InterruptedException {
        servo = hardwareMap.crservo.get("servo");
        telemetry.addData("How to Use", "Left trigger -> open. Right trgger -> close");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
//            if (gamepad1.left_trigger > .2) {
//                servo.setPower(gamepad1.left_trigger);
//            } else if (gamepad1.right_trigger > .2) {
//                servo.setPower(-gamepad1.right_trigger);
//            } else {
//                servo.setPower(0);
//            }
            if (gamepad1.a) {
                servo.setPower(0.5);
            } else {
                servo.setPower(-0.5);
            }
            telemetry.addData("rT", gamepad1.right_trigger);
            telemetry.addData("lT", gamepad1.left_trigger);
            telemetry.addData("servo", servo.getPower());
            telemetry.update();
        }
    }
}
