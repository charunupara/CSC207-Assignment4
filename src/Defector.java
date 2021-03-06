
public class Defector extends Organism {
  
  /* Constructor */
  public Defector() {
    super();
    this.coopProb = 0;
  }
  
  /* Methods */
  @Override
  public String getType() {
    return "Defector";
  }

  @Override
  public Organism reproduce() {
    Defector newOrganism = new Defector();
    return newOrganism;
  }

  @Override
  public double getCooperationProbability() {
    return 0;
  }

  @Override
  public boolean cooperates() {
    return false;
  }
}
