import java.util.ArrayList;
import java.util.List;

public class ViterbiHMM {

    
    public static class ViterbiResult {
        public List<String> optimalSequence;
        public double[][] viterbiMatrix;

        public ViterbiResult(List<String> optimalSequence, double[][] viterbiMatrix) {
            this.optimalSequence = optimalSequence;
            this.viterbiMatrix = viterbiMatrix;
        }
    }

    public static ViterbiResult viterbi(int[] obsSeq, String[] states, double[] startP, double[][] transP, double[][] emitP) {
        int numStates = states.length;
        int numObs = obsSeq.length;

        // viterbiMatrix tracks the maximum probability of reaching state i at time t
        double[][] viterbiMatrix = new double[numStates][numObs];
        // pathTracker records the state transition that resulted in the maximum probability
        int[][] pathTracker = new int[numStates][numObs];

       
        int firstObs = obsSeq[0];
        for (int i = 0; i < numStates; i++) {
            viterbiMatrix[i][0] = startP[i] * emitP[i][firstObs];
        }

        for (int t = 1; t < numObs; t++) {
            int currentObs = obsSeq[t];
            for (int currentState = 0; currentState < numStates; currentState++) {
                double maxProb = -1.0;
                int bestPrevState = 0;

                for (int prevState = 0; prevState < numStates; prevState++) {
                    
                    double prob = viterbiMatrix[prevState][t - 1] * transP[prevState][currentState] * emitP[currentState][currentObs];
                    if (prob > maxProb) {
                        maxProb = prob;
                        bestPrevState = prevState;
                    }
                }
                viterbiMatrix[currentState][t] = maxProb;
                pathTracker[currentState][t] = bestPrevState;
            }
        }

        int[] bestPath = new int[numObs];
        double maxFinalProb = -1.0;
        int bestFinalState = 0;
        for (int i = 0; i < numStates; i++) {
            if (viterbiMatrix[i][numObs - 1] > maxFinalProb) {
                maxFinalProb = viterbiMatrix[i][numObs - 1];
                bestFinalState = i;
            }
        }
        bestPath[numObs - 1] = bestFinalState;

        for (int t = numObs - 2; t >= 0; t--) {
            bestPath[t] = pathTracker[bestPath[t + 1]][t + 1];
        }

        List<String> optimalStateSequence = new ArrayList<>();
        for (int index : bestPath) {
            optimalStateSequence.add(states[index]);
        }

        return new ViterbiResult(optimalStateSequence, viterbiMatrix);
    }

    public static void printTextVisualization(double[][] matrix, String[] states, int[] observations, String[] obsLabels) {
        System.out.println("\nCalculated Probability Matrix Graph Over Time Step Tracker:");
        System.out.print(String.format("%-15s", "System State"));
        for (int t = 0; t < observations.length; t++) {
            System.out.print(String.format(" | T%d (%s)", t, obsLabels[observations[t]]));
        }
        System.out.println("\n" + "-".repeat(75));

        for (int i = 0; i < states.length; i++) {
            System.out.print(String.format("%-15s", states[i]));
            for (int t = 0; t < observations.length; t++) {
                System.out.print(String.format(" | %.5f", matrix[i][t]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        String[] hiddenStates = {"Healthy", "Under Attack"};
        String[] observableEvents = {"Low Traffic", "High Traffic", "Failed Login"};

        // Initial System Probabilities: 90% chance the server starts off healthy
        double[] startProbabilities = {0.90, 0.10};

        // Transition Matrix:
        // [Healthy -> Healthy (0.85),     Healthy -> Under Attack (0.15)]
        // [Under Attack -> Healthy (0.30), Under Attack -> Under Attack (0.70)]
        double[][] transitionMatrix = {
            {0.85, 0.15},
            {0.30, 0.70}
        };

        double[][] emissionMatrix = {
            {0.70, 0.25, 0.05},
            {0.05, 0.45, 0.50}
        };

        int[] obsSequence = {1, 2, 2, 0};

        ViterbiResult result = viterbi(obsSequence, hiddenStates, startProbabilities, transitionMatrix, emissionMatrix);

        System.out.println("HMM Viterbi Execution - Network Security Monitoring\n");
        System.out.println("-".repeat(60));
        System.out.printf("%-12s | %-15s | %-20s\n", "Time Log", "Network Alert", "Assessed Server State");
        System.out.println("-".repeat(60));

        for (int t = 0; t < obsSequence.length; t++) {
            String obsName = observableEvents[obsSequence[t]];
            String stateName = result.optimalSequence.get(t);
            System.out.printf("T = %-8d | %-15s | %-20s\n", t, obsName, stateName);
        }
        System.out.println("-".repeat(60));

        printTextVisualization(result.viterbiMatrix, hiddenStates, obsSequence, observableEvents);
    }
}
