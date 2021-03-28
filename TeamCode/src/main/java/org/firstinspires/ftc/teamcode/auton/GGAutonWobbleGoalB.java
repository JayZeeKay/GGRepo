package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous (name = "GGAutonWobbleGoalB", group = "a")
public class GGAutonWobbleGoalB extends LinearOpMode {

    Robot ggbot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        ggbot.init(hardwareMap, telemetry);
        ggbot.getDrivetrain().setTelemetry(telemetry);
        telemetry.addData("How to Use", "Park against the wall, over the tape on the right");
        telemetry.update();
        waitForStart();
        ggbot.getDrivetrain().forward(76, 0.5);
        ggbot.getDrivetrain().stop();
        sleep(1000);
        ggbot.getDrivetrain().backward(14, 0.3);
    }
}
