package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@TeleOp (name = "GGTeleop", group = "primary")
public class GGTeleop extends LinearOpMode {

    Robot ggbot;
    double rightSlide, leftSlide, rightMove, leftMove;

    @Override
    public void runOpMode() throws InterruptedException {
        ggbot.init(hardwareMap, telemetry);
        telemetry.addData("How to Use", "Basic Teleop")
                .addData("Drivetrain", "Tank Drive + Strafe. Use sticks to move")
                .addData("Intake", "Use dpad up to open up, dpad down to close in")
                .addData("Flywheel", "Use right trigger to shoot, left trigger to reverse")
                .addData("Belt", "Use ");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            // drivetrain
            rightSlide = -gamepad1.right_stick_x;
            leftSlide = -gamepad1.left_stick_x;
            rightMove = -gamepad1.right_stick_y;
            leftMove = -gamepad1.left_stick_y;
            ggbot.getDrivetrain().setRightSide(rightSlide + rightMove, -rightSlide + rightMove);
            ggbot.getDrivetrain().setLeftSide(-leftSlide + leftMove, leftSlide + leftMove);

            // flywheel
            if (Math.abs(gamepad1.right_trigger) > .2) {
                ggbot.getFlywheel().shoot(gamepad1.right_trigger);
            } else if (Math.abs(gamepad1.left_trigger) > .2) {
                ggbot.getFlywheel().reverse(gamepad1.left_trigger);
            } else {
                ggbot.getFlywheel().stop();
            }

            // intake
            if (gamepad1.dpad_up) {
                ggbot.getIntake().flipIn();
            } else if (gamepad1.dpad_down) {
                ggbot.getIntake().flipOut();
            } else {
                ggbot.getIntake().stop();
            }

            // belt
            if (gamepad1.a) {
                ggbot.getBelt().forward();
            } else {
                ggbot.getBelt().stop();
            }
        }
    }
}
