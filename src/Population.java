import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Population {
  PrintWriter pen = new PrintWriter(System.out, true);

  ArrayList<Organism> popList;

  public Population(Pair<String, Integer>[] counts) throws IllegalArgumentException {
    this.popList = new ArrayList<Organism>();

    for (int i = 0; i < counts.length; i++) {
      Pair<String, Integer> currentPair = counts[i];

      int check = 0;

      if (currentPair.getLeft().equals("Cooperator")) {
        for (int j = 0; j < currentPair.getRight(); j++) {
          Cooperator current = new Cooperator();
          this.popList.add(current);
          check++;
        }
      }

      if (currentPair.getLeft().equals("Defector")) {
        for (int j = 0; j < currentPair.getRight(); j++) {
          Defector current = new Defector();
          this.popList.add(current);
          check++;
        }
      }

      if (currentPair.getLeft().equals("PartialCooperator")) {
        for (int j = 0; j < currentPair.getRight(); j++) {
          PartialCooperator current = new PartialCooperator();
          this.popList.add(current);
          check++;
        }
      }

      if (check == 0) {
        throw new IllegalArgumentException("Type not recognized");
      }
    }
  }

  public void update() throws Exception {
    // checking every organism in population
    for (int i = 0; i < this.popList.size(); i++) {
      Organism current = this.popList.get(i);
      current.update();

      // if it cooperates
      if (current.cooperates()) {

        current.decrementEnergy();
        int[] randCount = new int[8];
        Random rand = new Random();

        // randomize 8 organisms
        for (int j = 0; j < 8; j++) {
          int n = rand.nextInt(this.popList.size());

          while (n == i) {
            n = rand.nextInt(this.popList.size());
          }

          for (int k = 0; k < 8; k++) {
            while (n == randCount[k]) {
              n = rand.nextInt(this.popList.size());
            }

            randCount[j] = n;
          }

          for (int k = 0; k < 8; k++) {

            this.popList.get(randCount[k]).incrementEnergy();
          }
        }

      } // cooperate

      // if organism is ready to reproduce
      if (current.getEnergy() >= 10) {
        // find a random organism to replace
        Random rand2 = new Random();
        int n = rand2.nextInt(this.popList.size());
        while (n == i) {
          n = rand2.nextInt(this.popList.size());
        }
        // replace that with an organism of the same type
        if (current.getType().equals("Cooperator")) {
          Cooperator newOrg = new Cooperator();
          this.popList.set(n, newOrg);
        }

        if (current.getType().equals("Defector")) {
          Defector newOrg = new Defector();
          this.popList.set(n, newOrg);
        }

        if (current.getType().equals("PartialCooperator")) {
          PartialCooperator newOrg = new PartialCooperator();
          this.popList.set(n, newOrg);
        }
      } // reproduce

    }

  }// update

  public double calculateCooperationMean() {
    double result = 0;

    for (int i = 0; i < this.popList.size(); i++) {
      result += this.popList.get(i).coopProb;
    }

    result = result / this.popList.size();

    return result;
  }

  public Pair<String, Integer>[] getPopulationCounts() {
    int coopCount = 0;
    int defectCount = 0;
    int partialCount = 0;

    for (int i = 0; i < this.popList.size(); i++) {
      Organism current = this.popList.get(i);

      if (current.getType().equals("Cooperator")) {
        coopCount++;
      }

      if (current.getType().equals("Defector")) {
        defectCount++;
      }

      if (current.getType().equals("PartialCooperator")) {
        partialCount++;
      }
    }

    Pair<String, Integer> coopPair = new Pair<String, Integer>("Cooperator", coopCount);
    Pair<String, Integer> defectPair = new Pair<String, Integer>("Defector", defectCount);
    Pair<String, Integer> partialPair =
        new Pair<String, Integer>("PartialCooperator", partialCount);

    @SuppressWarnings("unchecked")
    Pair<String, Integer>[] result = (Pair<String, Integer>[]) new Pair[3];
    
    result[0] = coopPair;
    result[1] = defectPair;
    result[2] = partialPair;

    return result;

  }
}
