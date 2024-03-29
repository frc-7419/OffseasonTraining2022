package frc.robot;

import com.team7419.joystick.DoubleButton;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RunIntakeAndLoaderWithJoystick;
import frc.robot.subsystems.arms.ArmsSubsystem;
import frc.robot.subsystems.arms.CoastArms;
import frc.robot.subsystems.arms.RunArmsWithJoystick;
import frc.robot.subsystems.autos.OneBallAuto;
import frc.robot.subsystems.autos.OneBallAutoWait;
import frc.robot.subsystems.autos.ThreeBallAutoExactVelocities;
import frc.robot.subsystems.autos.ThreeBallAutoInterpolation;
import frc.robot.subsystems.autos.TwoBallAutoDemo;
import frc.robot.subsystems.autos.TwoBallAutoExactVelocities;
import frc.robot.subsystems.autos.TwoBallAutoInterpolation;
import frc.robot.subsystems.drive.ArcadeDrive;
import frc.robot.subsystems.drive.DriveBaseSubsystem;
import frc.robot.subsystems.elevator.ElevatorSubsystem;
import frc.robot.subsystems.elevator.MaintainElevatorPosition;
import frc.robot.subsystems.elevator.RunElevatorWithJoystick;
import frc.robot.subsystems.feeder.FeederSubsystem;
import frc.robot.subsystems.feeder.RunFeederWithJoystick;
import frc.robot.subsystems.gyro.GyroSubsystem;
import frc.robot.subsystems.intake.DeployIntakeWithJoystick;
import frc.robot.subsystems.intake.IntakeSolenoidSubsystem;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.led.LEDSubsystem;
import frc.robot.subsystems.led.SetLEDColor;
import frc.robot.subsystems.led.SetLEDColorWithJoystick;
import frc.robot.subsystems.limelight.LimelightSubsystem;
import frc.robot.subsystems.loader.LoaderSubsystem;
import frc.robot.subsystems.shooter.GetToTargetVelocity;
import frc.robot.subsystems.shooter.GetToTargetVelocityArbitraryFeedforward;
import frc.robot.subsystems.shooter.GetToTargetVelocityWithLimelight;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import frc.robot.subsystems.turret.AlignTurretDefault;
import frc.robot.subsystems.turret.BrakeTurret;
import frc.robot.subsystems.turret.RunTurretWithJoystick;
import frc.robot.subsystems.turret.TurretSubsystem;

public class RobotContainer {
  private final XboxController joystick1 = new XboxController(0);
  private final XboxController joystick2 = new XboxController(1);
  private final DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final IntakeSolenoidSubsystem intakeSolenoidSubsystem = new IntakeSolenoidSubsystem();
  private final GyroSubsystem gyroSubsystem = new GyroSubsystem();
  private final LoaderSubsystem loaderSubsystem = new LoaderSubsystem();
  private final FeederSubsystem feederSubsystem = new FeederSubsystem();
  private final TurretSubsystem turretSubsystem = new TurretSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final ArmsSubsystem armsSubsystem = new ArmsSubsystem();
  private final LEDSubsystem ledSubsystem = new LEDSubsystem();

  private final RunIntakeAndLoaderWithJoystick runIntakeAndLoaderWithJoystick = new RunIntakeAndLoaderWithJoystick(joystick1, intakeSubsystem, loaderSubsystem);
  private final DeployIntakeWithJoystick deployIntakeWithJoystick = new DeployIntakeWithJoystick(intakeSolenoidSubsystem, joystick2);
  private final RunTurretWithJoystick runTurretWithJoystick = new RunTurretWithJoystick(turretSubsystem, limelightSubsystem, joystick2, 0.16);
  private final RunFeederWithJoystick runFeederWithJoystick = new RunFeederWithJoystick(feederSubsystem, joystick1);
  private final RunElevatorWithJoystick runElevatorWithJoystick = new RunElevatorWithJoystick(elevatorSubsystem, joystick2);
  private final RunArmsWithJoystick runArmsWithJoystick = new RunArmsWithJoystick(armsSubsystem, joystick2);
  private final SetLEDColor setLEDColor = new SetLEDColor(ledSubsystem, limelightSubsystem, driveBaseSubsystem);
  private final SetLEDColorWithJoystick setLEDColorWithJoystick = new SetLEDColorWithJoystick(ledSubsystem, limelightSubsystem, driveBaseSubsystem, joystick1, joystick2);
  // private final SetLED1Color setled1Color = new SetLED1Color(ledSubsystem, driveBaseSubsystem);
  private final ArcadeDrive arcadeDrive = new ArcadeDrive(joystick1, driveBaseSubsystem, 0.95, 0.75);

  // auto
  // private SendableChooser<Command> autonChooser = new SendableChooser<>();
  private final OneBallAuto oneBallAuto = new OneBallAuto(driveBaseSubsystem, gyroSubsystem, shooterSubsystem, limelightSubsystem, feederSubsystem, loaderSubsystem, ledSubsystem, turretSubsystem, intakeSubsystem, intakeSolenoidSubsystem);
  private final OneBallAutoWait oneBallAutoWait = new OneBallAutoWait(driveBaseSubsystem, gyroSubsystem, shooterSubsystem, limelightSubsystem, feederSubsystem, loaderSubsystem, ledSubsystem, turretSubsystem);
  private final TwoBallAutoDemo twoBallAutoDemo = new TwoBallAutoDemo(driveBaseSubsystem, gyroSubsystem, shooterSubsystem, limelightSubsystem, feederSubsystem, loaderSubsystem, ledSubsystem, turretSubsystem, intakeSubsystem, intakeSolenoidSubsystem);
  private final TwoBallAutoExactVelocities twoBallAutoExactVelocities = new TwoBallAutoExactVelocities(driveBaseSubsystem, gyroSubsystem, shooterSubsystem, feederSubsystem, loaderSubsystem, intakeSubsystem, turretSubsystem, limelightSubsystem, ledSubsystem, intakeSolenoidSubsystem);
  private final TwoBallAutoInterpolation twoBallAutoInterpolation = new TwoBallAutoInterpolation(driveBaseSubsystem, gyroSubsystem, shooterSubsystem, feederSubsystem, loaderSubsystem, intakeSubsystem, turretSubsystem, limelightSubsystem, ledSubsystem, intakeSolenoidSubsystem);
  private final ThreeBallAutoExactVelocities threeBallAutoExactVelocities = new ThreeBallAutoExactVelocities(turretSubsystem, limelightSubsystem, shooterSubsystem, loaderSubsystem, feederSubsystem, driveBaseSubsystem, gyroSubsystem, intakeSubsystem, intakeSolenoidSubsystem, ledSubsystem);
  private final ThreeBallAutoInterpolation threeBallAutoInterpolation = new ThreeBallAutoInterpolation(turretSubsystem, limelightSubsystem, shooterSubsystem, loaderSubsystem, feederSubsystem, driveBaseSubsystem, gyroSubsystem, intakeSubsystem, intakeSolenoidSubsystem, ledSubsystem);

  public RobotContainer() {
    configureButtonBindings();
    smartDashboardBindings();
    configureAutoSelector();
  }

  private void configureButtonBindings() {
    // demos
    new JoystickButton(joystick2, XboxController.Button.kY.value)
      .whileHeld(new GetToTargetVelocity(shooterSubsystem, 15, 15));

    new JoystickButton(joystick2, XboxController.Button.kX.value)
      .whileHeld(new GetToTargetVelocity(shooterSubsystem, 20, 20));

    // // align turret
    // new JoystickButton(joystick2, XboxController.Button.kLeftBumper.value)
    //   .whileHeld(new AlignTurretDefault(turretSubsystem, limelightSubsystem));
    
    // // brake turret during hang
    // new JoystickButton(joystick1, XboxController.Button.kB.value)
    //   .whileHeld(new BrakeTurret(turretSubsystem));

    //   // any distance, interpolation
    // new JoystickButton(joystick2, XboxController.Button.kY.value)
    //   .whileHeld(new GetToTargetVelocityWithLimelight(shooterSubsystem, limelightSubsystem));

    // // edge of tarmac
    // new JoystickButton(joystick2, XboxController.Button.kX.value)
    // .whileHeld(new GetToTargetVelocityArbitraryFeedforward(shooterSubsystem, 7900, 9900, 0.04874, 0.049));

    // // lower hub shot, consistent
    // new JoystickButton(joystick2, XboxController.Button.kA.value)
    //   .whileHeld(new GetToTargetVelocityArbitraryFeedforward(shooterSubsystem, 3500, 5450, 0.042, 0.0475));

    //   // coast arms during hanging
    // new JoystickButton(joystick2, XboxController.Button.kRightBumper.value)
    //   .whileHeld(new CoastArms(armsSubsystem));

    // // toggle to maintain elevator position
    // new DoubleButton(
    //   new JoystickButton(joystick2, XboxController.Button.kA.value),
    //   new JoystickButton(joystick2, XboxController.Button.kB.value))
    //   .toggleWhenPressed(new MaintainElevatorPosition(elevatorSubsystem));
  }

  private void smartDashboardBindings() {}

  private void configureAutoSelector() {
    // autonChooser.setDefaultOption("Preload Default", oneBallAuto);
    // autonChooser.addOption("2 Ball Exact Velocities", twoBallAutoExactVelocities);
    // autonChooser.addOption("2 Ball Interpolation", twoBallAutoInterpolation);
    // autonChooser.addOption("3 Ball Exact Velocities", threeBallAutoExactVelocities);
    // autonChooser.addOption("3 Ball Interpolation", threeBallAutoInterpolation);
    // SmartDashboard.putData(autonChooser);
  }

  public Command getAutonomousCommand() {
    // return oneBallAutoWait;
    return oneBallAuto;
    // return twoBallAutoDemo;bottomTargetVelocity
    // return twoBallAutoExactVelocities;
    // return twoBallAutoInterpoloation;
    // return threeBallAutoExactVelocities;
    // return threeBallAutoInterpolation;
    // return threeBallAuto;

    // return autonChooser.getSelected();
  }

  public void setDefaultCommands() {
    driveBaseSubsystem.setDefaultCommand(arcadeDrive);
    intakeSolenoidSubsystem.setDefaultCommand(deployIntakeWithJoystick);
    intakeSubsystem.setDefaultCommand(runIntakeAndLoaderWithJoystick);
    loaderSubsystem.setDefaultCommand(runIntakeAndLoaderWithJoystick); 
    feederSubsystem.setDefaultCommand(runFeederWithJoystick);
    turretSubsystem.setDefaultCommand(runTurretWithJoystick);
    elevatorSubsystem.setDefaultCommand(runElevatorWithJoystick);
    armsSubsystem.setDefaultCommand(runArmsWithJoystick);
    ledSubsystem.setDefaultCommand(setLEDColor);
  }
}

