package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous (name = "GGAutonPark", group = "a")
public class GGAutonPark extends LinearOpMode {

    Robot ggbot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        ggbot.init(hardwareMap, telemetry);
        ggbot.getDrivetrain().setTelemetry(telemetry);
        telemetry.addData("How to Use", "Park robot on right tape, against the wall");
        telemetry.update();
        waitForStart();
        ggbot.getDrivetrain().backward(62, 0.5);
    }
}
