import java.util.Random;

public class PartialCooperator extends Organism {

  public PartialCooperator() {
    super();
    this.coopProb = 0.5;
  }

  @Override
  public String getType() {
    return "PartialCooperator";
  }

  @Override
  public Organism reproduce() {
    PartialCooperator newOrganism = new PartialCooperator();
    return newOrganism;
  }

  @Override
  public double getCooperationProbability() {
    return 0.5;
  }

  @Override
  public boolean cooperates() {
    Random rand = new Random();
    int n = rand.nextInt(2);
    if (n == 1) {
      return true;
    }
    else {
      return false;
    }
  }

}
