import java.io.PrintWriter;

public class ALifeSim {

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    int iterations = Integer.parseInt(args[0]);
    int cooperators = Integer.parseInt(args[1]);
    int defectors = Integer.parseInt(args[2]);
    int partialCooperators = Integer.parseInt(args[3]);

    Pair<String, Integer> coopPair = new Pair<String, Integer>("Cooperator", cooperators);
    Pair<String, Integer> defectPair = new Pair<String, Integer>("Defector", defectors);
    Pair<String, Integer> partialPair =
        new Pair<String, Integer>("PartialCooperator", partialCooperators);

    @SuppressWarnings("unchecked")
    Pair<String, Integer>[] pop = (Pair<String, Integer>[]) new Pair[3];

    pop[0] = coopPair;
    pop[1] = defectPair;
    pop[2] = partialPair;

    Population population = new Population(pop);

    
    for (int i = 0; i < iterations; i++) {
      population.update();
    }
    pen.println("After " + iterations + " ticks:");
    pen.println("Cooperators =  " + population.getPopulationCounts()[0]);
    pen.println("Defectors =  " + population.getPopulationCounts()[1]);
    pen.println("Partial =  " + population.getPopulationCounts()[2]);
    
    pen.println("Mean Cooperation Probability = " + population.calculateCooperationMean());
  }



}
