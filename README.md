# AI Assignment Project

This repository contains professional Java implementations of fundamental Artificial Intelligence algorithms and interactive environments, organized into clean, modular workspaces.

---

## Project Structure

```text
ArtificialIntelligence-Assignment/
├── README.md               # Project documentation
├── alphabeta/
│   └── AlphaBetaVisualizer.java  # Game Tree Alpha-Beta search & DOT generator
├── hmm/
│   ├── ViterbiHMM.java     # Network Intrusion Detection Viterbi decoder
│   └── network_security_hmm_plot.png # Plotted probability path state curve
└── tictactoe/
    └── TicTacToe.java      # Premium Swing UI Tic-Tac-Toe Minimax Game
```
Workspace Modules1. Alpha-Beta Pruning (alphabeta/)An implementation of the Alpha-Beta pruning minimax optimization framework featuring runtime alpha/beta metadata tracking and automated visualization output.Core Logic: Dynamically checks mathematical bounds ($\beta \le \alpha$) to discard redundant structural subtrees.Features:Tracks precise historical terminal $\alpha$ and $\beta$ metrics per depth frame.Captures array coordinates of all dropped structural connections.Generates clean Graphviz DOT language scripts printed directly to the console for instant copy-paste rendering.2. Hidden Markov Model - Viterbi Algorithm (hmm/)A specialized dynamic-programming sequence decoder configured as a Network Security Intrusion Detection Monitor.The Scenario: A system infrastructure guessing internal system health (Healthy vs. Under Attack) based entirely on live network alert logs (Low Traffic, High Traffic, Failed Login).Features:Calculates explicit joint state-path log probabilities.Formats and prints a structured console text data-grid logging matrix trajectories over runtime.Includes an exported probability path curve (network_security_hmm_plot.png) showing state boundary crossovers.3. Tic-Tac-Toe with Minimax Engine (tictactoe/)An interactive, high-fidelity native Java Swing GUI implementation of Tic-Tac-Toe driven by an unbeatable adversarial Minimax AI Engine.Features:Sleek dark-mode aesthetic built completely via javax.swing and java.awt graphics primitives.Custom rendered geometric canvas components representing unique Totems (Human Green Circles vs. AI Gold Squares).Real-time algorithm dashboard diagnostics capturing execution step index targets and evaluation matrix states.Lookahead depth-penalized evaluation scores ensure the engine takes the shortest path to victory or a stalemate.Environment & RequirementsRuntime Environment: Java Development Kit (JDK) 8 or higher (JDK 17 or JDK 21 recommended).IDE Setup: Works out-of-the-box in Visual Studio Code (with the Extension Pack for Java installed) or IntelliJ IDEA.Dependencies: Uses native Java standard libraries (java.awt, javax.swing, java.util). No external build tool wrapper configurations (like Maven or Gradle) are required.Execution GuideRunning Modules via TerminalFrom your repository's root directory, navigate to your folder of choice to compile and execute the native Java classes:Alpha-Beta VisualizerBashcd alphabeta
javac AlphaBetaVisualizer.java
java AlphaBetaVisualizer
Visualizing the Tree: Copy the console block output starting with digraph G { ... } and paste it directly into a web engine like Graphviz Online to view your color-coded tree diagram model.Hidden Markov ModelBashcd hmm
javac ViterbiHMM.java
java ViterbiHMM
Interactive Tic-Tac-Toe GameBashcd tictactoe
javac TicTacToe.java
java TicTacToe
Technical Metrics ReferenceViterbi Decoding FrameworkTime Complexity: $O(N^2 \times T)$ where $N$ denotes structural state dimensions ($2$), and $T$ indicates observation time series stream length ($4$).Memory Footprint: $O(N \times T)$ array matrix allocation tracking weights.Game Tree Search ModelsAlpha-Beta Pruning: Optimizes standard branching factors down from an $O(b^d)$ exponential scale to $O(b^{d/2})$ under optimal configuration layouts.Minimax (Tic-Tac-Toe): Exhaustively scans the remaining turn state space ($9!$ maximum permutations) down to terminal leaf nodes to guarantee an optimal choice that ensures the AI cannot lose.
