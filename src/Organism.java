
public class Organism {
  /* Fields */
  int energy;
  double coopProb;

  /* Constructor */
  public Organism() {
    this.energy = 0;
  }

  /* Methods */
  public void update() {
    this.energy += 1;
  }

  public int getEnergy() {
    return this.energy;
  }

  public void incrementEnergy() {
    this.energy += 1;
  }

  public void decrementEnergy() throws Exception {
    if (this.energy <= 0) {
      new Exception("Energy cannot be decremented below zero");
    } else {
      this.energy -= 1;
    }
  }

  public String getType() {
    return this.getClass().getSimpleName();
  }

  public Organism reproduce() {
    Organism newOrganism = new Organism();
    return newOrganism;
  }

  public double getCooperationProbability() {
    return this.coopProb;
  }

  public boolean cooperates() {
    if (this.coopProb == 1) {
      return true;
    } else {
      return false;
    }
  }
}
