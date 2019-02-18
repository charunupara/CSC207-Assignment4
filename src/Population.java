import java.util.ArrayList;
import java.util.Random;

public class Population {

  ArrayList<Organism> popList;

  public Population(Pair<String, Integer>[] counts) throws IllegalArgumentException {
    this.popList = new ArrayList<Organism>();

    for (int i = 0; i < counts.length; i++) {
      Pair<String, Integer> currentPair = counts[i];

      if (currentPair.getLeft().equals("Cooperator")) {
        for (int j = 0; j < currentPair.getRight(); j++) {
          Cooperator current = new Cooperator();
          this.popList.add(current);
        }
      }

      if (currentPair.getLeft().equals("Defector")) {
        for (int j = 0; j < currentPair.getRight(); j++) {
          Defector current = new Defector();
          this.popList.add(current);
        }
      }

      if (currentPair.getLeft().equals("PartialCooperator")) {
        for (int j = 0; j < currentPair.getRight(); j++) {
          PartialCooperator current = new PartialCooperator();
          this.popList.add(current);
        }
      }
    }
  }

  public void update() throws Exception {
    for (int i = 0; i < this.popList.size(); i++) {
      Organism current = this.popList.get(i);
      current.update();

      if (current.cooperates()) {
        current.decrementEnergy();
        ArrayList<Integer> randCount = new ArrayList<Integer>();
        Random rand = new Random();

        for (int j = 0; j < 8; j++) {
          int n = rand.nextInt(this.popList.size());
          while (randCount.contains(n) || n == i) {
            n = rand.nextInt(this.popList.size());
          }
          
          
        }

      }

    }
  }
}
