
public class Cooperator extends Organism {

  /* Constructor */
  public Cooperator() {
    super();
    this.coopProb = 1;
  }
  
  /* Methods */
  @Override
  public String getType() {
    return "Cooperator";
  }
  
  @Override
  public Organism reproduce() {
    Cooperator newOrganism = new Cooperator();
    return newOrganism;
  }
  
  @Override
  public double getCooperationProbability() {
    return 1;
  }
  
  @Override
  public boolean cooperates() {
    return true;
  }

}
