JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Alien.java \
	AlienHorde.java \
	Ammo.java \
	Bullets.java \
	Moveable.java \
	MovingThing.java \
	OuterSpace.java \
	Ship.java \
	StarFighter.java \
	Shiptest.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class