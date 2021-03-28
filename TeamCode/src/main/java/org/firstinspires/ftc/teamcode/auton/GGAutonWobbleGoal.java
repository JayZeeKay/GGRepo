package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous (name = "GGAutonWobbleGoal", group = "a")
public class GGAutonWobbleGoal extends LinearOpMode {

    Robot ggbot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        ggbot.init(hardwareMap, telemetry);
        ggbot.getDrivetrain().setTelemetry(telemetry);
        telemetry.addData("How to Use", "Park against the wall, over the tape on the right");
        telemetry.update();
        waitForStart();
        ggbot.getDrivetrain().forward(62, 0.5);
    }
}
