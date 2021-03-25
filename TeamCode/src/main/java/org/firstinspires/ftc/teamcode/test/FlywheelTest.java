package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Flywheel;

@TeleOp (name = "FlywheelTest", group = "Test")
public class FlywheelTest extends LinearOpMode {

    public Flywheel flywheel;

    @Override
    public void runOpMode() throws InterruptedException {
        flywheel = new Flywheel(hardwareMap.dcMotor.get("leftFlywheel"), hardwareMap.dcMotor.get("rightFlywheel"));
        telemetry.addData("How to Use", "Use right trigger to shoot, left trigger to reverse");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.right_trigger > .2) {
                flywheel.shoot(gamepad1.right_trigger);
            } else if (gamepad1.left_trigger > .2) {
                flywheel.reverse(gamepad1.left_trigger);
            } else if (gamepad1.right_bumper) {
                flywheel.shoot();
            } else if (gamepad1.left_bumper) {
                flywheel.reverse();
            } else {
                flywheel.stop();
            }
            telemetry.addData("leftFlywheel", flywheel.getLeftFlywheel().getPower());
            telemetry.addData("rightFlywheel", flywheel.getRightFlywheel().getPower());
            telemetry.update();
        }
    }
}
