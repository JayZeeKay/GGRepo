package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@TeleOp (name = "GGTeleop", group = "a")
public class GGTeleop extends LinearOpMode {

    Robot ggbot = new Robot();
    double rightSlide, leftSlide, rightMove, leftMove;

    @Override
    public void runOpMode() throws InterruptedException {
        ggbot.init(hardwareMap, telemetry);
        ggbot.getDrivetrain().setTelemetry(telemetry);
        telemetry.addData("How to Use", "Basic Teleop")
                .addData("Drivetrain", "G1: Tank Drive + Strafe. Use sticks to move")
                .addData("Intake", "G1: r/l triggers to flip servos in/out.")
                .addData("Flywheel", "Use right bumper to shoot, left bumper to reverse")
                .addData("Belt", "G2: A to bring forward, B to reverse")
                .addData("Intake Geartrain", "G2: x/y button to forward/reverse intake geartrain");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            // drivetrain
            rightSlide = gamepad1.right_stick_x;
            leftSlide = gamepad1.left_stick_x;
            rightMove = gamepad1.right_stick_y;
            leftMove = gamepad1.left_stick_y;
            ggbot.getDrivetrain().setRightSide(-rightSlide + rightMove, rightSlide + rightMove);
            ggbot.getDrivetrain().setLeftSide(leftSlide + leftMove, -leftSlide + leftMove);

            // flywheel
//            if (Math.abs(gamepad2.right_trigger) > .2) {
//                ggbot.getFlywheel().shoot(gamepad2.right_trigger);
//            } else if (Math.abs(gamepad2.left_trigger) > .2) {
//                ggbot.getFlywheel().reverse(gamepad2.left_trigger);
//            } else {
//                ggbot.getFlywheel().stop();
//            }
            if (gamepad2.right_bumper) {
                ggbot.getFlywheel().shoot();
            } else if (gamepad2.left_bumper) {
                ggbot.getFlywheel().reverse();
            } else {
                ggbot.getFlywheel().stop();
            }

            // intake servo
            if (gamepad1.right_bumper) {
                ggbot.getIntake().flipIn();
            } else if (gamepad1.left_bumper) {
                ggbot.getIntake().flipOut();
            } else {
                ggbot.getIntake().stopServos();
            }

            // intake motor
            if (gamepad2.x) {
                ggbot.getIntake().pushOut();
            } else if (gamepad2.y) {
                ggbot.getIntake().pullIn();
            } else {
                ggbot.getIntake().stopMotor();
            }

            // belt
            if (gamepad2.a) {
                ggbot.getBelt().forward();
            } else if (gamepad2.b) {
                ggbot.getBelt().reverse();
            } else {
                ggbot.getBelt().stop();
            }

            telemetry.addData("How to Use", "Basic Teleop")
                    .addData("Drivetrain", "G1: Tank Drive + Strafe. Use sticks to move")
                    .addData("Intake", "G1: r/l bumper to flip servos in/out.")
                    .addData("Flywheel", "G2: Use right bumper to shoot, left bumper to reverse")
                    .addData("Belt", "G2: A to bring forward, B to reverse")
                    .addData("Intake Geartrain", "G2: x/y button to forward/reverse intake geartrain");
            telemetry.addData("frontLeft", ggbot.getDrivetrain().getFrontLeft().getPower())
                    .addData("frontRight", ggbot.getDrivetrain().getFrontRight().getPower())
                    .addData("backLeft", ggbot.getDrivetrain().getBackLeft().getPower())
                    .addData("backRight", ggbot.getDrivetrain().getBackRight().getPower())
                    .addData("frontLeftEnc", ggbot.getDrivetrain().getFrontLeft().getCurrentPosition())
                    .addData("frontRightEnc", ggbot.getDrivetrain().getFrontRight().getCurrentPosition())
                    .addData("backLeftEnc", ggbot.getDrivetrain().getBackLeft().getCurrentPosition())
                    .addData("backRightEnc", ggbot.getDrivetrain().getBackRight().getCurrentPosition());
            telemetry.update();
        }
    }
}
