package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.Delivery.Ports;

import static frc.robot.Constants.Delivery.*;

public class Delivery extends SubsystemBase {
    private final TalonFX deliveryMotor = new TalonFX(Ports.CONVEYOR_MOTOR_ID);

    @SuppressWarnings("removal")
    public Delivery() {
        var configs = new MotorOutputConfigs();
        configs.Inverted = InvertedValue.Clockwise_Positive;
        deliveryMotor.getConfigurator().apply(Constants.DELIVERY_CURRENT_LIMITS);
        stopDelivery();
    }

    public void stopDelivery() {
        setDeliveryMotor(0.0);
    }

    public void setDeliveryMotor(double power) {
        deliveryMotor.set(power);
    }

}
