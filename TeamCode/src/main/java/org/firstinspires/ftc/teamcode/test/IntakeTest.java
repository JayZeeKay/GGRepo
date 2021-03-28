package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Intake;

//@Disabled
@TeleOp (name = "IntakeTest", group = "Test")
public class IntakeTest extends LinearOpMode {

    public Intake intake;
    @Override
    public void runOpMode() throws InterruptedException {
        intake = new Intake(hardwareMap.crservo.get("leftFlipper"), hardwareMap.crservo.get("rightFlipper"), hardwareMap.dcMotor.get("puller"));
        telemetry.addData("How to Use", "Gamepad1: Right/left bumper to control flip in/out servos. Gamepad2: Right/left bumper to control intake geartrain");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
//            if (gamepad1.right_trigger > .2) {
//                intake.flipIn();
//            } else if (gamepad1.left_trigger > .2) {
//                intake.flipOut();
//            } else {
//                intake.stopServos();
//            }
            if (gamepad1.right_bumper) {
                intake.flipIn();
            } else if (gamepad1.left_bumper) {
                intake.flipOut();
            } else {
                intake.stopServos();
            }
            if (gamepad2.left_bumper) {
                intake.pushOut();
            } else if (gamepad2.right_bumper) {
                intake.pullIn();
            } else {
                intake.stopMotor();
            }
            telemetry.addData("rT", gamepad1.right_trigger);
            telemetry.addData("lT", gamepad1.left_trigger);
            telemetry.addData("rB", gamepad1.right_bumper);
            telemetry.addData("lB", gamepad1.left_bumper);
            telemetry.addData("rB2", gamepad2.right_bumper);
            telemetry.addData("lB2", gamepad2.left_bumper);
            telemetry.update();
        }
    }
}
