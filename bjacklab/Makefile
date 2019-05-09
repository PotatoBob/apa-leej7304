JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AbstractPlayer.java \
	BlackJack.java \
	BlackJackCard.java \
	Card.java \
	CardTestOne.java \
	Dealer.java \
	DealerTestOne.java \
	Deck.java \
	DeckTestOne.java \
	Player.java \
	Playerable.java \
	PlayerTestOne.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
