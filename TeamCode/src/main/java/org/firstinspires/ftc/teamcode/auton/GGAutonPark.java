package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous (name = "GGAutonPark", group = "primary")
public class GGAutonPark extends LinearOpMode {

    Robot ggbot;

    @Override
    public void runOpMode() throws InterruptedException {
        ggbot.init(hardwareMap, telemetry);
        telemetry.addData("How to Use", "Park robot on right tape");
        telemetry.update();
        waitForStart();
        ggbot.getDrivetrain().forward(24, 0.8);
    }
}
