package ch16.ex16_04;

public @interface BugsFixed {

	String[] fixedBy();

	String[] bugIDs();

	String[] value();

}
