package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystem.Robot;

@Autonomous (name = "GGAutonRingsB", group = "a")
public class GGAutonRingsB extends LinearOpMode {

    Robot ggbot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        ggbot.init(hardwareMap,telemetry);
        ggbot.getDrivetrain().setTelemetry(telemetry);
        telemetry.addData("How to Use", "Park against the wall");
        telemetry.update();
        waitForStart();
        ggbot.getDrivetrain().forward(104, 0.5);
        ggbot.getBelt().reverse();
        ggbot.getFlywheel().shoot();
        sleep(5000);
        ggbot.getBelt().stop();
        ggbot.getFlywheel().stop();
        ggbot.getDrivetrain().pointTurnLeft(0.5);
        sleep(500):
        ggbot.getDrivetrain().
    }
}
