package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous (name = "GGAutonTemplate", group = "Template")
public class GGAutonTemplate extends LinearOpMode {

    Robot ggbot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        ggbot.init(hardwareMap, telemetry);
        ggbot.getDrivetrain().setTelemetry(telemetry);
        telemetry.addData("How to Use", "");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            // type auton code in here
            ggbot.getDrivetrain().pointTurnLeft(0.3);
    }
}
