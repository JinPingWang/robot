package factory;

import robot.MapRobot;
import robot.Robot;
import robot.SemanticNetRobot;
import robot.TuringRobot;

public class RobotFactory {
	public static Robot createRobot(String robotType){
		if(robotType.equals("Turing")){
			return TuringRobot.getInstance();
		}
		else if(robotType.equals("Map")){
			return MapRobot.getInstance();
		}
		else {
			return SemanticNetRobot.getInstance();
		}
	}
}
