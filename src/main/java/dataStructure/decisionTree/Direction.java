package dataStructure.decisionTree;

public enum Direction {
	LEFT, RIGHT, STOP;

	static boolean isStopDirection(Direction direction) {
		return direction == Direction.STOP;
	}

	static boolean isLeftDirection(Direction direction) {
		return direction == Direction.LEFT;
	}

	static boolean isRightDirection(Direction direction) {
		return direction == Direction.RIGHT;
	}

}
